package projectgrouplf;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class App extends VBox {
    
    /** Left nearly everything i wantet to test public / default */
    private Text labelBaseHealth, labelBaseMoney, labelStoreTitle, labelUserAdded, enterUsername;
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

    private TextField textField; 
                                                  
    private Rectangle startingPoint = new Rectangle(20, 50);
    private Rectangle endingPoint = new Rectangle(20, 50);
    public static Coordinate startingCord = new Coordinate(50, 225);
    public static Coordinate endingCord = new Coordinate(850, 225);
    public double direction = 0; // the initial direction of the enemies should be to the right (=0)

    private int numberOfEnemies = 10;
    private int numberOfEnemyRanks = 3;
    private ArrayList<Defender> defenderArray = new ArrayList<Defender>();
    private ArrayList<Enemy> startingEnemyArray = new ArrayList<Enemy>();
    private ArrayList<Enemy> inGameEnemyArray = new ArrayList<Enemy>();

    /** The rank that an Defender has when clicking the "add Defender" btn */
    private int defenderRank;
    /** Every x times a new Enemy is displayed in the gamePane and gets attacked by the Defender */
    private boolean buyButtonClicked = false;

    /** Adds an Enemy to the gamePane / gets a hit by a Defender every X times */
    private int gameLoopCounter = 0;
    private Timeline timeline;

    /** For the endPane, the userData */
    private String userDataString;
    private File scoreBoard = new File(Base.scoreBoardRelativePath);
    private ArrayList<Player> playerArray;

    /** Streets */
    private Street street = new Street();

    public App() {

        // all the labels
        labelBaseHealth = new Text("Health: " + Base.getBaseHealth());
        labelBaseHealth.setFill(Color.rgb(210, 20, 20));
        labelBaseHealth.setStyle("-fx-font-size: 15px;");

        labelBaseMoney = new Text("$ " + Base.getBaseMoney());
        labelBaseMoney.setFill(Color.GOLD);
        labelBaseMoney.setStyle("-fx-font-size: 15px;");

        labelStoreTitle = new Text("War Industry");
        labelStoreTitle.setFill(Color.BISQUE);
        labelStoreTitle.setTextAlignment(TextAlignment.CENTER);
        labelStoreTitle.setStyle("-fx-font-size: 20px;");
        
        // buttons
        buySmallDefenderButton = new Button("lil Uzi 25$");
        buySmallDefenderButton.setPrefWidth(100);
        buySmallDefenderButton.setOnAction((ActionEvent event) -> {
            buyButtonClicked = true;
            defenderRank = 1;
            setOnMouseClicked(this::addDefenderOnMouseCordinatePosition);
        });
        buyNormalDefenderButton = new Button("Agent O. 50$");
        buyNormalDefenderButton.setPrefWidth(100);
        buyNormalDefenderButton.setOnAction((ActionEvent event) -> {
            buyButtonClicked = true;
            defenderRank = 2;
            setOnMouseClicked(this::addDefenderOnMouseCordinatePosition);
        });
        buyBigDefenderButton = new Button("Big Berta 80$");
        buyBigDefenderButton.setPrefWidth(100);
        buyBigDefenderButton.setOnAction((ActionEvent event) -> {
            buyButtonClicked = true;
            defenderRank = 3;
            setOnMouseClicked(this::addDefenderOnMouseCordinatePosition);
        });

        playNormalButton = new Button("Play");
        playNormalButton.setPrefWidth(100);
        playNormalButton.setOnAction((ActionEvent event) -> {
            Base.survival = false;
            Base.survivalOrNormalBaseHealt();
            getChildren().remove(startGameArea);
            getChildren().add(mainArea);

            setUpStreet();

            new MissionInfoPane();
            timeline.play();
        });
        playSurvivalButton = new Button("Play Survival");
        playSurvivalButton.setPrefWidth(100);
        playSurvivalButton.setOnAction((ActionEvent event) -> {
            Base.survival = true;
            Base.survivalOrNormalBaseHealt();
            getChildren().remove(startGameArea);
            getChildren().add(mainArea);
            
            setUpStreet();

            new MissionInfoPane();
            timeline.play();
        });
        scoreBoardButton = new Button("Score Board");
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
        pausePlayButton = new Button("Pause");
        pausePlayButton.setPrefWidth(100);
        pausePlayButton.setOnAction((ActionEvent event) -> {
            pauseGame();
        });
        continueButton = new Button("Resume");
        continueButton.setPrefWidth(100);
        continueButton.setOnAction((ActionEvent event) -> {
            getChildren().remove(pauseGameArea);
            getChildren().add(mainArea);
            timeline.play();
        });
        guideButton = new Button("Guide");
        guideButton.setPrefWidth(100);
        guideButton.setOnAction((ActionEvent event) -> {
            new HelpPane();
        });

        addUserButton = new Button("Add User");
        addUserButton.setPrefWidth(100);
        addUserButton.setOnAction((ActionEvent event) -> {
            if (false == textField.getText().isEmpty()) {
                String userName = new String(textField.getText());
                String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
                userDataString = new String("Player: " + userName + ", Health: " + Base.getBaseHealth()+ ", Money: " + Base.getBaseMoney()+ ", Game mode: " + Base.getBaseGameMode() + ", Date: " + date + ".");

                updateScoreBoard();

                addUserBox.getChildren().add(labelUserAdded);
                addUserBox.getChildren().remove(addUserButton);
                addUserBox.getChildren().remove(textField);
                addUserBox.getChildren().remove(enterUsername);
            }
        });
        restartButton = new Button("Restart");
        restartButton.setPrefWidth(100);
        restartButton.setOnAction((ActionEvent event) -> {
            resetGame();
            getChildren().remove(endGameArea); // remove both bcs this btn is used in both
            getChildren().remove(pauseGameArea);
            getChildren().add(mainArea);
        });
        backToMenuButton = new Button("Back to Menu");
        backToMenuButton.setPrefWidth(100);
        backToMenuButton.setOnAction((ActionEvent event) -> {
            resetGame();
            timeline.pause();
            getChildren().remove(endGameArea); // remove both bcs this btn is used in both
            getChildren().remove(pauseGameArea);

            for (int i = 0; i < street.lineArray.size(); i++)
                gamePane.getChildren().remove(street.lineArray.get(i));

            showStartPane();
        });
        quitButton = new Button("Quit");
        quitButton.setPrefWidth(100);
        quitButton.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });

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

        startingPoint.setFill(Color.RED);
        endingPoint.setFill(Color.BLUE);

        gamePane = new Pane(startingPoint, endingPoint);
        gamePane.setPrefSize(900, 450);
        gamePane.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        leftArea = new VBox(topLeftArea, storeArea);
        mainArea = new HBox(leftArea, gamePane);
        setSpacing(20);
        setAlignment(Pos.CENTER);


        // THIS IS THE GAME

        showStartPane();

        // cerate an arrayList with all the enemies
        startingEnemyArray = Enemy.setNewEnemyArray(numberOfEnemies, numberOfEnemyRanks);

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.04), ev -> { // normal speed: 0.04?
            int i = 0;
            while (i < inGameEnemyArray.size()) {
                if (inGameEnemyArray.get(i).checkIfEnemyReachedBase(endingCord))
                    removeEnemy(inGameEnemyArray.get(i));
                if (gameLoopCounter % 22 == 0) // how often Defence damages Enemy 
                    checkIfEnemyInDefenderRadius(inGameEnemyArray.get(i));
                if (inGameEnemyArray.size() == i) { // in case that the Enemy was killed, should end loop
                    break;
                }
                // moves Enemies
               
                for (int j = 0; j < street.coordinateArray.size(); j++) {
                    if ( (inGameEnemyArray.get(i).getEnemyCoordinate().getCoordinateX() == street.coordinateArray.get(j).getCoordinateX()) && (inGameEnemyArray.get(i).getEnemyCoordinate().getCoordinateY() == street.coordinateArray.get(j).getCoordinateY()) ) {
                        inGameEnemyArray.get(i).setEnemyDirection(street.coordinateArray.get(j).enemyDirection);
                    }
                }
                inGameEnemyArray.get(i).enemyMovesForward(5, endingCord);
                i++;
            }
            if (gameLoopCounter % 32 == 0) // here should wait
                addEnemyToGameArea();
            updateTexts();
            gameLoopCounter++;
            boolean gameIsFinished = (Base.getBaseHealth() <= 0 || Base.getBaseMoney() < 0 || (startingEnemyArray.size() == 0 && inGameEnemyArray.size() == 0 && Base.getBaseHealth() > 0));
            if (gameIsFinished) { // ends game
                timeline.pause();
                showEndPane();
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.pause();
    }


    /** 
     * Needed if enemy has live 0 (= is dead) or has reached EndingPoint (=defenders Base).
     *  The circle, the health label and the enemy in the inGameArray is removed.
     * @param enemy
    **/
    private void removeEnemy(Enemy enemy) {
        gamePane.getChildren().remove(enemy.enemyCircle);
        enemy.deleteEnemyText();
        inGameEnemyArray.remove(enemy);
    }

    /** Removes every Defenders rectangle and attackCircle from the gamePane */
    private void removeEveryDefender() {
        if (defenderArray.size() > 0) {
            for (int i = 0; i < defenderArray.size(); i++) {
                gamePane.getChildren().remove(defenderArray.get(i).defenderRectangle);
                gamePane.getChildren().remove(defenderArray.get(i).defenderAttackCircle);
            }
        }
    }

    /** 
     * Checks if the current enemy touches or collides with the attacCircle of every Defender in the gamePane.
     *  Checks if the 4 enemy Point2Ds (cirlce-top, bottom, left, and right) are contained in the defenderArrackCircle 
     *  If that is the case, the health of the enemy is decreased once and if no more health, increase Base money and the met "removeEnemy()" is invoced.
     * @param enemy
    **/
    public void checkIfEnemyInDefenderRadius(Enemy enemy) { // here i created just the loop for the defenders
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

    /** Adds the Defenders rectangle and attackCircle to the gamePane */
    private void addDefenderToGameArea() {
        gamePane.getChildren().addAll(defenderArray.get(defenderArray.size()-1).defenderRectangle);
        gamePane.getChildren().addAll(defenderArray.get(defenderArray.size()-1).defenderAttackCircle);
    }

    /** Adds the Enemies circle and Text to the Pane, adds them to the inGameArray and removes them form the initialArray **/
    private void addEnemyToGameArea() {
        if (startingEnemyArray.size() != 0) {
            gamePane.getChildren().addAll(startingEnemyArray.get(0).enemyCircle);
            gamePane.getChildren().addAll(startingEnemyArray.get(0).enemyHealthText);
            inGameEnemyArray.add(startingEnemyArray.get(0));
            startingEnemyArray.remove(0);
        }
    }

    /** Converts the mouseposition click into a coordinate and places there a new Defender */
    public void addDefenderOnMouseCordinatePosition(MouseEvent event) {
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
                updateTexts();
            }
            buyButtonClicked = false;
        }
        return;
    }

    /**  */
    private void showStartPane() {
        Text title = new Text("Blood for Freedom");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFill(Color.rgb(255, 30, 70));
        title.setStyle("-fx-font-size: 30px;");
        Text textMadaByUs = new Text("              Tower Defense game by Felix Demetz und Lucas Glück v1.3");
        textMadaByUs.setTextAlignment(TextAlignment.LEFT);
        textMadaByUs.setFill(Color.WHITE);
        Text text = new Text();
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFill(Color.WHITE);
        Text hintText = new Text("Hint: for first time players pls click on \"Guide\".");
        hintText.setTextAlignment(TextAlignment.CENTER);
        hintText.setFill(Color.YELLOW);

        String bestPlayerString = "* No Player *";
		String bestSurvivalPlayerString = "* No Player *";

        VBox mainBox = new VBox(title, text, hintText, playNormalButton, playSurvivalButton, guideButton, scoreBoardButton, quitButton);
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(20);

        startGameArea = new VBox(mainBox, textMadaByUs);
        setBackground(new Background(new BackgroundFill(Color.rgb(30, 30, 30), CornerRadii.EMPTY, Insets.EMPTY)));
		
        playerArray = Player.getPlayerArray(); // sets up two list with all the Players
		Player bestNormal = Player.getBestHealthPlayer(playerArray, true);
		if (bestNormal != null) // if there was at least one
			bestPlayerString = bestNormal.playerName;
		Player bestSurvival = Player.getBestHealthPlayer(playerArray, false);
		if (bestSurvival != null) // if there was at least one
			bestSurvivalPlayerString = bestSurvival.playerName;

        text.setText("High Score:\n\nNormal Mode: " + bestPlayerString + "         Survival Mode: " + bestSurvivalPlayerString);

        getChildren().add(startGameArea);
    }

    /** changes the Pane showing one of tree possible finishes */
    private void showEndPane() {
        int endNr = 0;
        if (Base.getBaseHealth() <= 0)
            endNr = 1; // lose
        if (Base.getBaseMoney() < 0)
            endNr = 2; // lose
        if (startingEnemyArray.size() == 0 && inGameEnemyArray.size() == 0 && Base.getBaseHealth() > 0) {
            endNr = 3; // win
        }

        labelUserAdded = new Text("Score board updated");
        labelUserAdded.setFill(Color.WHITE);
        Text endText = new Text();
        endText.setFill(Color.WHITE);
        enterUsername = new Text("Enter username: ");
        enterUsername.setFill(Color.WHITE);
        Text endTextTitle = new Text();
        Text endTextScore = new Text("\nYour score: Health: " + Base.getBaseHealth() + ", Money: " + Base.getBaseMoney() + ", on mode: " + Base.getBaseGameMode());
        endTextScore.setFill(Color.WHITE);
        endTextTitle.setTextAlignment(TextAlignment.CENTER);
        endTextTitle.setFill(Color.RED);
        endTextTitle.setStyle("-fx-font-size: 30px;");

        textField = new TextField("");
        textField.setMaxWidth(200);

        addUserBox = new HBox(enterUsername, textField, addUserButton);
        addUserBox.setSpacing(20);
        addUserBox.setAlignment(Pos.CENTER);

        endGameArea = new VBox(endTextTitle, endText, endTextScore, addUserBox, restartButton, backToMenuButton);
        if (endNr != 3)
            endGameArea.getChildren().remove(addUserBox);

        endGameArea.setSpacing(20); // space betweeen V/HBox elements
        endGameArea.setAlignment(Pos.CENTER);
        getChildren().remove(mainArea);
        getChildren().add(endGameArea);

        switch(endNr) {
            case 1: // no more Base Health
                endTextTitle.setText("Total elimination");
                endTextTitle.setFill(Color.RED);
                endText.setText("Your Base was eradicated and those who still live would prefer dead over this hell."
                    + "\n"
                    + "\nEnemys newspaper:"
                    + "\nMission: \"ethnic cleansing accomplished!\""
                    + "\n");
                break;
            case 2: // no more Base Money
                endTextTitle.setText("Red guns");
                endTextTitle.setFill(Color.RED);
                endText.setText("Oh no, the War Industry prefers money over the flag."
                    + "\n"
                    + "\nThe guns got a new Enemy-Red color, as you got out of money."
                    + "\nThe military corporations have switched the turntables and will now defend anothers freedom..."
                    + "\n");
                break;
            case 3: // no more Enemies
                endTextTitle.setText("Liberty?");
                endTextTitle.setFill(Color.GREEN);
                endText.setText("No more Enemies, no more Reds, just Blue flags everywere, everybody is happy..."
                    + "\n"
                    + "\nAs the days passes on, you slowly start to doubt:"
                    + "\n"
                    + "\nwho was the Defender and who the Enemy, who was the invador and who the victim,"
                    + "\nwho is the good and who is the bad one."
                    + "\n"
                    + "\nbut \"the winner is always right\", or isn't it..."
                    + "\n");
                break;
          }
	}

    /** 
     *
    **/
    private void pauseGame() {
        timeline.pause();

        Text pauseText = new Text("Game paused");
        pauseText.setTextAlignment(TextAlignment.CENTER);
        pauseText.setFill(Color.WHITE);
        pauseText.setStyle("-fx-font-size: 30px;");

        pauseGameArea = new VBox(pauseText, continueButton, restartButton, guideButton, backToMenuButton);
        pauseGameArea.setSpacing(20);
        pauseGameArea.setAlignment(Pos.CENTER);

        getChildren().remove(mainArea);
        getChildren().add(pauseGameArea);
    }

    /** 
     * Resetes the game. Stops the timeline, resets the Base data (health and money), clears the arrays containing
     *  Enemies and Defenders, removes the elements from the gamePane.
    **/
    private void resetGame() {
        timeline.stop();
                
        Base.survivalOrNormalBaseHealt();
        Base.resetBaseMoney();

        for (int i = 0; i < inGameEnemyArray.size(); i++) {
            gamePane.getChildren().remove(inGameEnemyArray.get(i).enemyCircle);
            inGameEnemyArray.get(i).deleteEnemyText();
        }
        
        inGameEnemyArray.clear();
        removeEveryDefender();
        defenderArray.clear();

        startingEnemyArray.clear();
        startingEnemyArray = Enemy.setNewEnemyArray(numberOfEnemies, numberOfEnemyRanks);
        updateTexts();
        timeline.play();
    }

    /** Updates the Texts (the text Health, Money, the game description and the health of every Enemy) */
    private void updateTexts() {
        labelBaseHealth.setText("Health: " + Base.getBaseHealth());
        labelBaseMoney.setText("$ " + Base.getBaseMoney());
        for (int i = 0; i < inGameEnemyArray.size(); i++) {
            inGameEnemyArray.get(i).getEnemyHealthText().setText("" + inGameEnemyArray.get(i).getEnemyHealth());
        }
    }

    /** Adds to the current Score Board text (.txt) file the current content and the new User with the Userdata */
    private void updateScoreBoard() {
        String oldScoreBoard = Base.readUserScoreBoard();
        
        try (FileWriter writer = new FileWriter(scoreBoard)) {
            writer.append(oldScoreBoard);
            writer.append(userDataString);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /** Adds adds to the GamePane a new Street with End and Start points */
    private void setUpStreet() {
        street = street.getRandomStreet();
        for (int i = 0; i < street.lineArray.size(); i++)
            gamePane.getChildren().add(street.lineArray.get(i));

        startingPoint.setX(startingCord.getCoordinateX() - startingPoint.getWidth());
        startingPoint.setY(startingCord.getCoordinateY() - startingPoint.getHeight()/2);
        endingPoint.setX(street.coordinateArray.get(street.coordinateArray.size()-1).getCoordinateX());
        endingPoint.setY(street.coordinateArray.get(street.coordinateArray.size()-1).getCoordinateY() - endingPoint.getHeight()/2);
    }
}