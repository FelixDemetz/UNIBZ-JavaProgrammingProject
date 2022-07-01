package projectgrouplf;

import java.util.ArrayList;

public class Player {

    public String playerName = "";
    public int playerHealth = 0;
    public int playerMoney = 0;
    public String playerGameMode = "";

    public Player(String playerName, int playerHealth, int playerMoney, String playerGameMode) {
        this.playerName = playerName;
        this.playerHealth = playerHealth;
        this.playerMoney = playerMoney;
        this.playerGameMode = playerGameMode;
    }

    /** Static met (we do not need to create an Player to invoke the met) gives best Normal Player out of array and returns the best. It initializes a player to "null", 
     *  if the array has only one element it returns this, else it compares beginning with the first element every Plaer's Health in the array */
    public static Player getBestHealthPlayer(ArrayList<Player> array, boolean normalGameMode) {
        ArrayList<Player> list = new ArrayList<>();
        Player best = null;
        if (array == null)
            return best;
        for (int i = 0; i < array.size(); i++) { // creating a new array with
            if (normalGameMode == playerIsNormal(array.get(i))) {
                list.add(array.get(i));
            }
        }
		if (list.size() == 1)
            best = list.get(0);
		for (int i = 0; i < list.size(); i++) {
            if (list.get(0).playerHealth <list.get(i).playerHealth) {
                best = list.get(i);
            }
		}
		return best;
	}

    /** Static met returns an ArrayList of Players that are read out of the Base.readUserScoreBoard() met. This met works with regex, and sets and add corrisponding Players*/
    public static ArrayList<Player> getPlayerArray() {
        ArrayList<Player> playersArray = new ArrayList<Player>();
		String scoreBoard = Base.readUserScoreBoard();
		String[] arrayPlayer = scoreBoard.split(System.lineSeparator());

		String regexValidData = "Player: .+, Health: (-)?\\d+, Money: (-)?\\d+, Game mode: (Normal||Survival), Date: .+";

		for (int i = 0; i < arrayPlayer.length; i++) {

			if (false == arrayPlayer[i].matches(regexValidData)) { // if the first string is corrupt
				if (arrayPlayer[i].matches("^$")) // and if it is emthy it should end met
					return null;
				try {
					throw new ExecptionFileNotFound();
				} catch (ExecptionFileNotFound e) {
					e.printStackTrace();
				}
				return null;
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

            playersArray.add(new Player(playerName, Integer.parseInt(playerHealth), Integer.parseInt(playerMoney), playerGameMode));
        
        }
        return playersArray;
    }

    private static boolean playerIsNormal(Player player) {
        boolean result = true;
        if (player.playerGameMode.equals("Survival")) {
            result = false;
        }
        return result;
    }

}
