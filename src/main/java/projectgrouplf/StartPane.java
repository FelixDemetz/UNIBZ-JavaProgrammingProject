
package projectgrouplf;

import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;


public class StartPane {

	ArrayList<Player> arrayListPlayerNormal = new ArrayList<>();
	ArrayList<Player> arrayListPlayerSurvival = new ArrayList<>(); 

	public StartPane() {
		Alert dialog = new Alert(AlertType.INFORMATION);
    	dialog.setTitle("Launcher");
    	dialog.setHeaderText("Blood for Freedom");
		dialog.setGraphic(null);

		String bestPlayerString = "* No Player *";
		String bestSurvivalPlayerString = "* No Player *";

		setBestPlayers(); // sets up two list with all the Players
		Player bestNormal = getBestPlayer(arrayListPlayerNormal);
		if (bestNormal != null) // if there was at least one
			bestPlayerString = bestNormal.playerName;
		
			Player bestSurvival = getBestPlayer(arrayListPlayerSurvival);
		if (bestSurvival != null) // if there was at least one
			bestSurvivalPlayerString = bestSurvival.playerName;

		dialog.setContentText("Tower defence game by Felix Demetz and Lucas Glick \n v 1.1"
		+ "\n"
		+ "\nHigh Score:\nNormal Mode: " + bestPlayerString + "         Survival Mode: " + bestSurvivalPlayerString
		+ "\n"
		+ "\n"
		+ "\nHint: for first time players pls click on \"Quide\".");
		
		ButtonType playButtonType = new ButtonType("Play");
		ButtonType playSurvivalButtonType = new ButtonType("Play Survival");
		ButtonType helpButtonType = new ButtonType("Quide");
		ButtonType scoreBoardButtonType = new ButtonType("Score Board");
		ButtonType quitButtonType = new ButtonType("Quit");		

		dialog.getButtonTypes().setAll(playButtonType, playSurvivalButtonType, helpButtonType, scoreBoardButtonType, quitButtonType);

		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == playButtonType) {
			dialog.close();
		}
		if (result.get() == playSurvivalButtonType) {
			//dialog.close();
			Base.survival = true;
			new MissionInfoPane();
			}
		if (result.get() == helpButtonType) {
			new HelpPane();
			new StartPane();
		}
		if (result.get() == scoreBoardButtonType) {
			Alert scoreBoard = new Alert(AlertType.INFORMATION);
    		scoreBoard.setTitle("Score Board");
    		scoreBoard.setHeaderText(null);
			scoreBoard.setGraphic(null);

			if (Base.readUserScoreBoard().matches("^$"))
				scoreBoard.setContentText("* No score registerd *");
			else
				scoreBoard.setContentText(Base.readUserScoreBoard());

			ButtonType backButtonType = new ButtonType("Back");
			scoreBoard.getButtonTypes().setAll(backButtonType);
			Optional<ButtonType> result2 = scoreBoard.showAndWait();
			if (result2.get() == playButtonType) {
				scoreBoard.close();
			}
			new StartPane();
		}
		if (result.get() == quitButtonType) {
			Platform.exit();
		}
	}

	private void setBestPlayers() {
		String scoreBoard = Base.readUserScoreBoard();
		String[] arrayPlayer = scoreBoard.split(System.lineSeparator());

		String regexValidData = "Player: .+, Health: (-)?\\d+, Money: (-)?\\d+, Game mode: (Normal||Survival), Date: .+";

		for (int i = 0; i < arrayPlayer.length; i++) {

			if (false == arrayPlayer[i].matches(regexValidData)) { // if the first string is corrupt
				if (arrayPlayer[i].matches("^$")) // and if it is emthy it should end met
					return;
				try {
					throw new ExecptionFileNotFound();
				} catch (ExecptionFileNotFound e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			String[] aP = arrayPlayer[i].split("(, Health).+"); // get the Name
			String[] bP = aP[0].split("(Player: )");
			String playerName = bP[1];

			String[] aH = arrayPlayer[i].split(".+, Health: "); // get the Health
			String[] bH = aH[1].split(", Money.+");
			String playerHealth = bH[0];

			String[] aM = arrayPlayer[i].split("((.+)Money: )"); // get the Money
			String[] bM = aM[1].split(", Game.+");
			String playerMoney = bM[0];

			String[] aGm = arrayPlayer[i].split("Player.+Game mode: "); // get the GameMode
			String[] bGm = aGm[1].split(", D.*");
			String playerGameMode = bGm[0];

			if (playerGameMode.equals("Survival"))
				arrayListPlayerSurvival.add(new Player(playerName, Integer.parseInt(playerHealth), Integer.parseInt(playerMoney)));
			else if (playerGameMode.equals("Normal"))
				arrayListPlayerNormal.add(new Player(playerName, Integer.parseInt(playerHealth), Integer.parseInt(playerMoney)));
		}
	}

	private Player getBestPlayer(ArrayList<Player> list) {
		Player best = null;
		if (list.size() == 1)
			best = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			best = list.get(0);
			if (list.get(0).playerHealth < list.get(i).playerHealth) {
				//if (list.get(0).playerHealth == list.get(i).playerHealth)
				best = list.get(i);
			}
		}
		return best;
	}


	
}
