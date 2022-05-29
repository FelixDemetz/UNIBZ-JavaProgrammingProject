package projectgrouplf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class App extends VBox {
    
    public Label labelBaseHealth, labelBaseMoney, labelBuyDefenderInfo, labelStoreTitle, labelUserAdded;

    private Button buySmallDefenderButton, buyNormalDefenderButton, buyBigDefenderButton, pausePlayButton, continueButton, guideButton, playNormalButton, playSurvivalButton, scoreBoardButton, backToMenuButton;
    private Button addUserButton, restartButton, quitButton;
    private HBox mainArea;
    private VBox leftArea;
    private VBox topLeftArea;
    private VBox storeArea;
    private Pane gamePane;

    private VBox endGameArea;
    private HBox addUserBox;
    private VBox pauseGameArea;
    private VBox startGameArea;

    private TextField textField =new TextField(""); 
                                                  
    private Rectangle startingPoint = new Rectangle(100, 0, 20, 450);
    private Rectangle endingPoint = new Rectangle(800, 0, 20, 450);
    private Coordinate startingCordindateEnemy = new Coordinate(startingPoint.getX(), startingPoint.getY()+startingPoint.getHeight()/2);

    private ArrayList<Defender> defenderArray = new ArrayList<Defender>();
    private ArrayList<Enemy> initialEnemyArray = new ArrayList<Enemy>();
    private ArrayList<Enemy> inGameEnemyArray = new ArrayList<Enemy>();

    private int numberOfEnemiesInArray = 10;
    /** The rank that an Defender has when clicking the "add Defender" btn */
    private int defenderRank;

    /** Every x times a new Enemy is displayed in the gamePane and gets attacked by the Defender */
    boolean buyButtonClicked = false;
    /** Boolean for Start and Pause btn */
    boolean gameRun = true;

    /** Adds an Enemy to the gamePane / gets a hit by a Defender every X times */
    private int enemyReleaser;
    private Timeline timeline;

    /** For the endPane, the userData */
    private String userDataString;
    private File scoreBoard = new File(Base.scoreBoardRelativePath);
    ArrayList<Player> arrayListPlayerNormal = new ArrayList<>();
	ArrayList<Player> arrayListPlayerSurvival = new ArrayList<>(); 

    public App() {

        // all the enemies
        newEnemyArray();

        // all the labels
        labelBaseHealth = new Label("Health: " + Base.getBaseHealth());
        labelBaseMoney = new Label("$ " + Base.getBaseMoney());
        labelBuyDefenderInfo = new Label("To buy defence,"
        + "\npress a button"
        + "\nin the green bx"
        + "\nthen, click on the"
        + "\nbattlefield to place"
        + "\nthe unit.");
        labelStoreTitle = new Label("War Industry");
        labelStoreTitle.setTextFill(Color.BISQUE);
        labelStoreTitle.setAlignment(Pos.CENTER);
        labelStoreTitle.setStyle("-fx-font-size: 20px;");

        labelBaseHealth.setTextFill(Color.rgb(210, 20, 20));
        labelBaseHealth.setStyle("-fx-font-size: 15px;");

        labelBaseMoney.setTextFill(Color.GOLD);
        labelBaseMoney.setStyle("-fx-font-size: 15px;");

        labelBuyDefenderInfo.setTextFill(Color.WHITE);
        
        // buttons
        buySmallDefenderButton = new Button("Lil Uzi 25$");
        buySmallDefenderButton.setPrefWidth(100);
        buySmallDefenderButton.setOnAction((ActionEvent event) -> {
            buyButtonClicked = true;
            defenderRank = 1;
            // here show the radius of the defender
            setOnMouseClicked(this::getMouseCoordinateClick);
        });
        buyNormalDefenderButton = new Button("Agent O. 50$");
        buyNormalDefenderButton.setPrefWidth(100);
        buyNormalDefenderButton.setOnAction((ActionEvent event) -> {
            buyButtonClicked = true;
            defenderRank = 2;
            setOnMouseClicked(this::getMouseCoordinateClick);
        });
        buyBigDefenderButton = new Button("Big Berta 80$");
        buyBigDefenderButton.setPrefWidth(100);
        buyBigDefenderButton.setOnAction((ActionEvent event) -> {
            buyButtonClicked = true;
            defenderRank = 3;
            setOnMouseClicked(this::getMouseCoordinateClick);
        });

        playNormalButton = new Button();
        playNormalButton.setText("Play");
        playNormalButton.setPrefWidth(100);
        playNormalButton.setOnAction((ActionEvent event) -> {
            Base.survival = false;
            Base.survivalOrNormalBaseHealt();
            getChildren().remove(startGameArea);
            getChildren().add(mainArea);
            new MissionInfoPane();
            timeline.play();
        });
        playSurvivalButton = new Button();
        playSurvivalButton.setText("Play Survival");
        playSurvivalButton.setPrefWidth(100);
        playSurvivalButton.setOnAction((ActionEvent event) -> {
            Base.survival = true;
            Base.survivalOrNormalBaseHealt();
            getChildren().remove(startGameArea);
            getChildren().add(mainArea);
            new MissionInfoPane();
            timeline.play();
        });
        scoreBoardButton = new Button();
        scoreBoardButton.setText("Score Board");
        scoreBoardButton.setPrefWidth(100);
        scoreBoardButton.setOnAction((ActionEvent event) -> {
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
			if (result2.get() == backButtonType) {
				scoreBoard.close();
			}
        });
        pausePlayButton = new Button();
        pausePlayButton.setText("Pause");
        pausePlayButton.setPrefWidth(100);
        pausePlayButton.setOnAction((ActionEvent event) -> {
            timeline.pause();
            pauseGame();
        });
        continueButton = new Button();
        continueButton.setText("Resume");
        continueButton.setPrefWidth(100);
        continueButton.setOnAction((ActionEvent event) -> {
            getChildren().remove(pauseGameArea);
            getChildren().add(mainArea);
            timeline.play();
        });
        guideButton = new Button();
        guideButton.setText("Guide");
        guideButton.setPrefWidth(100);
        guideButton.setOnAction((ActionEvent event) -> {
            new HelpPane();
        });

        addUserButton = new Button();
        addUserButton.setText("Add User");
        addUserButton.setPrefWidth(100);
        addUserButton.setOnAction((ActionEvent event) -> {
            if (false == textField.getText().isEmpty()) {
                String userName = new String(textField.getText());
                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                userDataString = new String("Player: " + userName + ", Health: " + Base.getBaseHealth()+ ", Money: " + Base.getBaseMoney()+ ", Game mode: " + Base.getBaseGameMode() + ", Date: " + date + ".");

                addUsertoScoreBoard();

                addUserBox.getChildren().add(labelUserAdded);
                addUserBox.getChildren().remove(addUserButton);
                addUserBox.getChildren().remove(textField);
            }
        });
        restartButton = new Button();
        restartButton.setText("Restart");
        restartButton.setPrefWidth(100);
        restartButton.setOnAction((ActionEvent event) -> {
            resetGame();
            getChildren().remove(endGameArea); // remove both bcs this btn is used in both
            getChildren().remove(pauseGameArea);
            getChildren().add(mainArea);
        });
        backToMenuButton = new Button();
        backToMenuButton.setText("Back to Menu");
        backToMenuButton.setPrefWidth(100);
        backToMenuButton.setOnAction((ActionEvent event) -> {
            resetGame();
            timeline.pause();
            getChildren().remove(endGameArea); // remove both bcs this btn is used in both
            getChildren().remove(pauseGameArea);
            showStartPane();
        });
        quitButton = new Button();
        quitButton.setText("Quit");
        quitButton.setPrefWidth(100);
        quitButton.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

        // THIS IS THE GAME
        showStartPane();

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.025), ev -> { // normal speed: 0.025?
            int i = 0;
            while (i < inGameEnemyArray.size()) {
                checkIfEnemyReachedBase(inGameEnemyArray.get(i));
                if (enemyReleaser % 32 == 0) // how often Defence damages Enemy 
                    checkIfEnemyInDefenderRadius(inGameEnemyArray.get(i));
                if (inGameEnemyArray.size() == i) {
                    break;
                }
                inGameEnemyArray.get(i).enemyMovesForward(2.5, endingPoint);
                i++;
            }
            if (enemyReleaser % 32 == 0) // here should wait
                addEnemyToGameArea();
            updateLabels();
            enemyReleaser++;
            // boolean gameFinished = (Base.getBaseMoney() < 0 || (initialEnemyArray.size() == 0 && inGameEnemyArray.size() == 0 && Base.getBaseHealth() > 0 && Base.getBaseMoney() >= 0));
            if (Base.getBaseHealth() <= 0 || Base.getBaseMoney() < 0 || (initialEnemyArray.size() == 0 && inGameEnemyArray.size() == 0 && Base.getBaseHealth() > 0)) { // ends game
                timeline.pause();
                Platform.runLater(()-> { // this is needed, so the met in EndPane "showAndWait()" does not throw Exception in thread "JavaFX Application Thread" java.lang.IllegalStateException: showAndWait is not allowed during animation or layout processing
                    choosesEndPane();
                });
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.pause();


        // the buttonsArea
        topLeftArea = new VBox(labelBaseHealth, labelBaseMoney, pausePlayButton);
        topLeftArea.setPrefSize(125, 125);
        topLeftArea.setSpacing(10); // space betweeen V/HBox elements
        topLeftArea.setAlignment(Pos.CENTER);
        topLeftArea.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        // the storeArea
        storeArea = new VBox(labelStoreTitle, buySmallDefenderButton, buyNormalDefenderButton, buyBigDefenderButton);
        storeArea.setPrefSize(125, 325);
        storeArea.setSpacing(20); // space betweeen V/HBox elements
        storeArea.setAlignment(Pos.CENTER);
        storeArea.setBackground(new Background(new BackgroundFill(Color.rgb(73, 95, 31), CornerRadii.EMPTY, Insets.EMPTY)));
        // start, stop and the line
        startingPoint.setFill(Color.BLACK);
        endingPoint.setFill(Color.WHITE);
        Line street = new Line(startingPoint.getX(), startingPoint.getY()+startingPoint.getHeight()/2, endingPoint.getX(), endingPoint.getY()+startingPoint.getHeight()/2);
        street.setFill(Color.GRAY);

        gamePane = new Pane(startingPoint, endingPoint, street);
        gamePane.setPrefSize(900, 450);
        gamePane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        leftArea = new VBox(topLeftArea, storeArea);
        mainArea = new HBox(leftArea, gamePane);

        setSpacing(20);
        setAlignment(Pos.CENTER);
    }


    /** Resetes the game. Stops the timeline, resets the Base data (health and money), clears the arrays containing
     *  Enemies and Defenders, removes the elements from the gamePane.
     *
    **/
    public void resetGame() {
        pausePlayButton.setText("Pause");
        gameRun = true;

        timeline.stop();
                
        Base.survivalOrNormalBaseHealt();
        Base.resetBaseMoney();

        for (int i = 0; i < inGameEnemyArray.size(); i++) {
            gamePane.getChildren().remove(inGameEnemyArray.get(i).enemyCircle);
            inGameEnemyArray.get(i).deleteEnemyLabel();
        }
        inGameEnemyArray.clear();
        removeDefender();
        defenderArray.clear();

        initialEnemyArray.clear();
        newEnemyArray();
        updateLabels();
        timeline.play();
    }
    /** Needed if enemy has live 0 (= is dead) or has reached EndingPoint (=defenders Base).
     *  The circle, the health label and the enemy in the inGameArray is removed.
     * @param enemy
    **/
    private void removeEnemy(Enemy enemy) {
        gamePane.getChildren().remove(enemy.enemyCircle);
        enemy.deleteEnemyLabel();
        inGameEnemyArray.remove(enemy);
    }

    /** Removes every Defenders recktangle and attackCircle from the gamePane */
    private void removeDefender() {
        if (defenderArray.size() != 0) {
            for (int i = 0; i < defenderArray.size(); i++) {
                gamePane.getChildren().remove(defenderArray.get(i).defenderRectangle);
                gamePane.getChildren().remove(defenderArray.get(i).defenderAttackCircle);
            }
        }
    }

    /** Adds to an array the number of enemies */
    private void newEnemyArray() {
        initialEnemyArray.clear();
        for (int i = 0; i < numberOfEnemiesInArray; i++) {
            initialEnemyArray.add(new Enemy(startingCordindateEnemy, randomEnemyRank()));
        } 
    }

    private void checkIfEnemyReachedBase(Enemy enemy) {
        if (enemy.getEnemyCoordinate().getCoordinateX() > endingPoint.getX()) { // for every Enemy that is after the finish get damage, remove
            Base.setBaseHealth(Base.getBaseHealth() - enemy.getEnemyDamage());
            removeEnemy(enemy);
        }
    }

    /** Checks if the current enemy touches or collides with the attacCircle of every Defender in the gamePane.
     *  Checks if the 4 enemy Point2Ds (cirlce-top, bottom, left, and right) are contained in the defenderArrackCircle 
     *  If that is the case, the health of the enemy is decreased once and if no more health, increase Base money and the met "removeEnemy()" is invoced.
     * @param enemy
    **/
    private void checkIfEnemyInDefenderRadius(Enemy enemy) { // here i created just the loop for the defenders
        Point2D enemyNordPoint = new Point2D(enemy.enemyCircle.getCenterX(), enemy.enemyCircle.getCenterY() + enemy.enemyCircle.getRadius()); 
        Point2D enemySudPoint = new Point2D(enemy.enemyCircle.getCenterX(), enemy.enemyCircle.getCenterY() - enemy.enemyCircle.getRadius()); 
        Point2D enemyWestPoint = new Point2D(enemy.enemyCircle.getCenterX() - enemy.enemyCircle.getRadius(), enemy.enemyCircle.getCenterY()); 
        Point2D enemyEastPoint = new Point2D(enemy.enemyCircle.getCenterX() + enemy.enemyCircle.getRadius(), enemy.enemyCircle.getCenterY()); 
        
        for (int i = 0; i < defenderArray.size(); i++) { // in the if it checks if one of the 4 enemies circles points (top, bottom, left or right) is contained in the defenderAttacCircle
            if (defenderArray.get(i).defenderAttackCircle.contains(enemyNordPoint) || defenderArray.get(i).defenderAttackCircle.contains(enemySudPoint) || defenderArray.get(i).defenderAttackCircle.contains(enemyWestPoint) || defenderArray.get(i).defenderAttackCircle.contains(enemyEastPoint)) {
                enemy.setEnemyHealth(enemy.getEnemyHealth() - defenderArray.get(i).getDefenderDamage());
            }
            if (enemy.getEnemyHealth() <= 0) { // if the enemy has no more health
                Base.setBaseMoney(Base.getBaseMoney() + enemy.getEnemyMoney());
                removeEnemy(enemy);
            }
            if (inGameEnemyArray.size() == 0) { // may be true if the removeEnemy met removes the last one
                return;
            }
        }
    }

    /** Adds the Defenders recktangle and attackCircle to the gamePane */
    private void addDefenderToGameArea() {
        gamePane.getChildren().addAll(defenderArray.get(defenderArray.size()-1).defenderRectangle);
        gamePane.getChildren().addAll(defenderArray.get(defenderArray.size()-1).defenderAttackCircle);
    }

    /** Adds the Enemies circle and Label to the Pane, adds them to the inGameArray and removes them form the initialArray **/
    private void addEnemyToGameArea() {
        if (initialEnemyArray.size() != 0) {
            gamePane.getChildren().addAll(initialEnemyArray.get(0).enemyCircle);
            gamePane.getChildren().addAll(initialEnemyArray.get(0).enemyHealthLabel);
            inGameEnemyArray.add(initialEnemyArray.get(0));
            initialEnemyArray.remove(0);
        }
    }

    /** Converts the mouseposition click into a coordinate and places there a new Defender */
    private void getMouseCoordinateClick(MouseEvent event) {
        if (buyButtonClicked) {
            Coordinate c = new Coordinate(event.getX()-125, event.getY()); // -125 bcs there is the "leftArea"
            if (gamePane.contains(c.getCoordinateX(), c.getCoordinateY())) {
                if (defenderRank == 1) {
                    defenderArray.add(new Defender(c, defenderRank));
                    Base.setBaseMoney(Base.getBaseMoney() - 25);
                }
                if (defenderRank == 2) {
                    defenderArray.add(new Defender(c, defenderRank));
                    Base.setBaseMoney(Base.getBaseMoney() - 50);
                }
                if (defenderRank == 3) {
                    defenderArray.add(new Defender(c, defenderRank));
                    Base.setBaseMoney(Base.getBaseMoney() - 80);
                }
                addDefenderToGameArea();
                updateLabels();
            }
            buyButtonClicked = false;
        }
        return;
    }

    /** Checks if the game is finished and opens the EndPane() class */
    private void choosesEndPane() {
        if (Base.getBaseHealth() <= 0)
            showEndPane(1);
        if (Base.getBaseMoney() < 0)
            showEndPane(2);
        if (initialEnemyArray.size() == 0 && inGameEnemyArray.size() == 0 && Base.getBaseHealth() > 0) {
            showEndPane(3);
        }
    }

    /**  */
    private void showStartPane() {
        Label title = new Label("Blood for Freedom");
        Label textMadaByUs = new Label("              Tower Defense game by Felix Demetz und Lucas Glück v1.2");
        title.setAlignment(Pos.CENTER);
        title.setTextFill(Color.rgb(255, 30, 70));
        title.setStyle("-fx-font-size: 30px;");
        textMadaByUs.setAlignment(Pos.BOTTOM_LEFT);
        textMadaByUs.setTextFill(Color.WHITE);

        String bestPlayerString = "* No Player *";
		String bestSurvivalPlayerString = "* No Player *";

        Label text = new Label();
        text.setAlignment(Pos.CENTER);
        text.setTextFill(Color.WHITE);

        VBox mainBox = new VBox(title, text, playNormalButton, playSurvivalButton, guideButton, scoreBoardButton, quitButton);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(20);

        startGameArea = new VBox(mainBox, textMadaByUs);
        setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
		
        setBestPlayers(); // sets up two list with all the Players
		Player bestNormal = getBestPlayer(arrayListPlayerNormal);
		if (bestNormal != null) // if there was at least one
			bestPlayerString = bestNormal.playerName;
		Player bestSurvival = getBestPlayer(arrayListPlayerSurvival);
		if (bestSurvival != null) // if there was at least one
			bestSurvivalPlayerString = bestSurvival.playerName;

        text.setText("High Score:\nNormal Mode: " + bestPlayerString + "         Survival Mode: " + bestSurvivalPlayerString
		+ "\n"
		+ "\n"
		+ "\nHint: for first time players pls click on \"Quide\".");

        getChildren().add(startGameArea);
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

    /** Opens a new Alert Pane with three different textes regarding the input parameter (1, 2, lose and 3 for win) */
    public void showEndPane(int endNr) {

        labelUserAdded = new Label("Score board updated");
        labelUserAdded.setTextFill(Color.WHITE);
        Label endText = new Label();
        endText.setTextFill(Color.WHITE);
        Label endTextTitle = new Label();
        Label endTextScore = new Label("\nYour score: Health: " + Base.getBaseHealth() + ", Money: " + Base.getBaseMoney() + ", on mode: " + Base.getBaseGameMode());
        endTextScore.setTextFill(Color.WHITE);
        endTextTitle.setAlignment(Pos.CENTER);
        endTextTitle.setTextFill(Color.RED);
        endTextTitle.setStyle("-fx-font-size: 30px;");

        textField.setMaxWidth(200);

        addUserBox = new HBox(textField, addUserButton);
        addUserBox.setSpacing(20);
        addUserBox.setAlignment(Pos.CENTER);

        endGameArea = new VBox(endTextTitle, endText, endTextScore, addUserBox, restartButton, backToMenuButton, quitButton);
        endGameArea.setSpacing(20); // space betweeen V/HBox elements
        endGameArea.setAlignment(Pos.CENTER);
        getChildren().remove(mainArea);
        getChildren().add(endGameArea);

        switch(endNr) {
            case 1: // no more Base Health
                endTextTitle.setText("You Lost!");
                endTextTitle.setTextFill(Color.RED);
                endText.setText("Your Base was eradicated and those who still live would prefer dead over this hell"
                    + "\n"
                    + "Enemys newspaper:"
                    + "\nMission: \"ethnic cleansing accomplished!\""
                    + "\n");
                break;
            case 2: // no more Base Money
                endTextTitle.setText("You Lost!");
                endTextTitle.setTextFill(Color.RED);
                endText.setText("Oh no, the War Industry prefers money over the flag"
                    + "\n"
                    + "\nThe military corporations have switched the turntables and will now defend anothers freedom..."
                    + "\n");
                break;
            case 3: // no more Enemies
                endTextTitle.setText("You Won?");
                endTextTitle.setTextFill(Color.GREEN);
                endText.setText("No more Enemies, no more Reds, just Blue flags everywere, everybody is happy..."
                    + "\n"
                    + "\nAs the days passes on, you slowly start to doubt:"
                    + "\n"
                    + "\nwho was the Defender and who the Enemy,"
                    + "\nwho was the invador and who the victim,"
                    + "\nwho is the good and who is the bad one."
                    + "\n"
                    + "\nbut \"the winner is always right\", or isn't it..."
                    + "\n");
                break;
          }
	}

    /** Adds to the current Score Board text (.txt) file the current content and the new User with the Userdata */
    private void addUsertoScoreBoard() {
        String oldScoreBoard = Base.readUserScoreBoard();
        
        try (FileWriter writer = new FileWriter(scoreBoard)) {
            writer.append(oldScoreBoard);
            writer.append(userDataString);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /** 
     *
    **/
    private void pauseGame() {
        Label pauseText = new Label("Game paused");
        pauseText.setAlignment(Pos.CENTER);
        pauseText.setTextFill(Color.WHITE);
        pauseText.setStyle("-fx-font-size: 30px;");

        // endGameArea.setBackground(value);

        pauseGameArea = new VBox(pauseText, continueButton, restartButton, guideButton, backToMenuButton, quitButton);
        pauseGameArea.setSpacing(20);
        pauseGameArea.setAlignment(Pos.CENTER);

        getChildren().remove(mainArea);
        getChildren().add(pauseGameArea);
    }

    /** Updates the Labels (the text Health, Money, the game description and the health of every Enemy) */
    private void updateLabels() {
        labelBaseHealth.setText("Health: " + Base.getBaseHealth());
        labelBaseMoney.setText("$ " + Base.getBaseMoney());
        for (int i = 0; i < inGameEnemyArray.size(); i++) {
            inGameEnemyArray.get(i).getEnemyHealthLabel().setText("" + inGameEnemyArray.get(i).getEnemyHealth());
        }
    }
    
    private int randomEnemyRank() {
        Random randy = new Random();
        return randy.nextInt(3)+1;
    }
}