package projectgrouplf.projectlf;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;

import javafx.event.ActionEvent;

import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    public Label labelBaseHealth, labelBaseMoney, labelBuyDefenderInfo, labelStoreTitle;

    public Button startButton, pauseButton, buySmallDefenderButton, buyNormalDefenderButton, buyBigDefenderButton, quitButton;
    public HBox mainArea;
    public VBox leftArea;
    public VBox topLeftArea;
    public VBox centerLeftArea;
    public VBox bottomLeftArea;
    public VBox storeArea;
    public Pane gameArea;
                                                  
    public Rectangle startingPoint = new Rectangle(100, 0, 20, 450);
    public Rectangle endingPoint = new Rectangle(800, 0, 20, 450);

    public ArrayList<Defender> defenderArray = new ArrayList<Defender>();
    public ArrayList<Enemy> enemyArray = new ArrayList<Enemy>();
    public ArrayList<Enemy> copyOfenemyArray = new ArrayList<Enemy>();
    public ArrayList<Enemy> inGameEnemyArray = new ArrayList<Enemy>();
    private int defenderRank;

    boolean buyButtonClicked = false;
    boolean gameRun = true; // boolean for Start and Pause btn

    // public Timer gameTimer;
    public int EnemyReleaser;
    public Timeline timeline;

    public App() {

        // Base
        Base.survivalOrNormalBaseHealt();

        // all the enemies
        Coordinate startingCordindateEnemy = new Coordinate(startingPoint.getX(), startingPoint.getY()+startingPoint.getHeight()/2);
        enemyArray.add(new Enemy(startingCordindateEnemy, 1)); // we could add more enemy types in the future
        enemyArray.add(new Enemy(startingCordindateEnemy, 2));
        enemyArray.add(new Enemy(startingCordindateEnemy, 3));
        enemyArray.add(new Enemy(startingCordindateEnemy, 1));
        enemyArray.add(new Enemy(startingCordindateEnemy, 2));
        enemyArray.add(new Enemy(startingCordindateEnemy, 3));
        copyOfenemyArray.addAll(enemyArray);

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
        buySmallDefenderButton.setOnAction((ActionEvent event) -> {
            labelBuyDefenderInfo.setText("Now click on"
            + "\nthe battlefield"
            + "\nto place the unit");
            buyButtonClicked = true;
            defenderRank = 1;
            // here show the radius of the defender
            
            // setOnMouseDragged(new EventHandler<MouseEvent>() {
            //     @Override public void handle(MouseEvent event) {
            //       String msg =
            //         "(x: "       + event.getX()      + ", y: "       + event.getY()       + ") -- " +
            //         "(sceneX: "  + event.getSceneX() + ", sceneY: "  + event.getSceneY()  + ") -- " +
            //         "(screenX: " + event.getScreenX()+ ", screenY: " + event.getScreenY() + ")";
          
            //       reporter.setText(msg);
            //     }
            //   });

            setOnMouseClicked(this::getMouseCoordinateClick);
        });
        buyNormalDefenderButton = new Button("Agent O. 50$");
        buyNormalDefenderButton.setOnAction((ActionEvent event) -> {
            labelBuyDefenderInfo.setText("Now click on"
            + "\nthe battlefield"
            + "\nto place the unit");
            buyButtonClicked = true;
            defenderRank = 2;
            setOnMouseClicked(this::getMouseCoordinateClick);
        });
        buyBigDefenderButton = new Button("Big Berta 80$");
        buyBigDefenderButton.setOnAction((ActionEvent event) -> {
            labelBuyDefenderInfo.setText("Now click on"
            + "\nthe battlefield"
            + "\nto place the unit");
            buyButtonClicked = true;
            defenderRank = 3;
            setOnMouseClicked(this::getMouseCoordinateClick);
        });

        pauseButton = new Button("Pause");
        pauseButton.setOnAction((ActionEvent event) -> {
            timeline.pause();
            // new PausePane();
        });
        quitButton = new Button("Continue");
        quitButton.setOnAction((ActionEvent event) -> {
            // Platform.exit();
            timeline.play();
        });  


        startButton = new Button("Declare war");
        startButton.setOnAction((ActionEvent event) -> { // https://stackoverflow.com/questions/26916640/javafx-not-on-fx-application-thread-when-using-timer

                timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), ev -> {
                    for (int i = 0; i < inGameEnemyArray.size(); i++) { // this is the game
                        checkIfEnemyReachedBase(inGameEnemyArray.get(i));
                        if (inGameEnemyArray.size() == 0) {// HERE IS AN ERROR WHEN THERE IS NO ENEMY LEFT ON FIELD
                            System.out.println("size 0 in the main for loop");
                            break;
                        }
                        checkIfEnemyInDefenderRadius(inGameEnemyArray.get(i));
                        inGameEnemyArray.get(i).enemyMovesForward(endingPoint, labelBaseHealth);
                        if (inGameEnemyArray.size() == 0) {// HERE IS AN ERROR WHEN THERE IS NO ENEMY LEFT ON FIELD
                            System.out.println("size 0 in the main for loop");
                            break;
                        }
                    }
                    // try {
                    //     TimeUnit.SECONDS.sleep(1);
                    // } catch (InterruptedException e) {
                    //     // TODO Auto-generated catch block
                    //     e.printStackTrace();
                    // }
                    if (EnemyReleaser % 8 == 0) // here should wait 
                        addEnemyToGameArea();
                    updateLabels();
                    EnemyReleaser++;
                    if (Base.getBaseHealth() < 0) {
                        // gameTimer.cancel();
                        displayEndPane(); // is not able to show, but can pause and continue
                        return;
                    }
                }));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
        });


        // the buttonsArea
        topLeftArea = new VBox(labelBaseHealth, labelBaseMoney, startButton);
        topLeftArea.setPrefSize(125, 100);
        topLeftArea.setSpacing(10); // space betweeen V/HBox elements
        topLeftArea.setAlignment(Pos.CENTER);
        topLeftArea.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        
        // the area with the game description
        centerLeftArea = new VBox(labelBuyDefenderInfo);
        centerLeftArea.setPrefSize(125, 250);
        centerLeftArea.setSpacing(10); // space betweeen V/HBox elements
        centerLeftArea.setAlignment(Pos.CENTER);
        centerLeftArea.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        // the bottomLeftArea;
        bottomLeftArea = new VBox(pauseButton, quitButton);
        bottomLeftArea.setPrefSize(125, 100);
        bottomLeftArea.setSpacing(10); // space betweeen V/HBox elements
        bottomLeftArea.setAlignment(Pos.CENTER);
        bottomLeftArea.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        // the storeArea
        storeArea = new VBox(labelStoreTitle, buySmallDefenderButton, buyNormalDefenderButton, buyBigDefenderButton);
        storeArea.setPrefSize(125, 20);
        storeArea.setSpacing(20); // space betweeen V/HBox elements
        storeArea.setAlignment(Pos.CENTER);
        storeArea.setBackground(new Background(new BackgroundFill(Color.rgb(73, 95, 31), CornerRadii.EMPTY, Insets.EMPTY)));
        // start, stop and the line
        startingPoint.setFill(Color.BLACK);
        endingPoint.setFill(Color.WHITE);
        Line street = new Line(startingPoint.getX(), startingPoint.getY()+startingPoint.getHeight()/2, endingPoint.getX(), endingPoint.getY()+startingPoint.getHeight()/2);
        street.setFill(Color.GRAY);

        gameArea = new Pane(startingPoint, endingPoint, street);
        gameArea.setPrefSize(900, 450);
        gameArea.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        leftArea = new VBox(topLeftArea, centerLeftArea, bottomLeftArea);
        mainArea = new HBox(leftArea, storeArea, gameArea);

        setSpacing(20);
        setAlignment(Pos.CENTER);
        getChildren().add(mainArea);
    }





    /** The met is needed if enemy has live 0 (= is dead) or has reached EndingPoint (=defenders Base).
     *  The circle, the health label and the enemy in the inGameArray is removed.
     * @param enemy
    **/
    private void removeEnemy(Enemy enemy) {
        gameArea.getChildren().remove(enemy.enemyCircle);
        enemy.deleteEnemyLabel();
        inGameEnemyArray.remove(enemy);
    }
    private void checkIfEnemyReachedBase(Enemy enemy) {
        if (enemy.getEnemyCoordinate().getCoordinateX() > endingPoint.getX()) { // for every Enemy that is after the finish get damage, remove
            Base.setBaseHealth(Base.getBaseHealth() - enemy.getEnemyDamage());
            removeEnemy(enemy);
        }
    }
    /** The met checks if the current enemy touches or collides with the attacCircle of every Defender in the gameArea.
     *  The met checks if the 4 enemy Point2Ds (cirlce-top, bottom, left, and right) are contained in the defenderArrackCircle 
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
                System.out.println("Commie was hit");
            }
            if (enemy.getEnemyHealth() <= 0) { // if the enemy has no more health
                Base.setBaseMoney(Base.getBaseMoney() + enemy.getEnemyMoney());
                removeEnemy(enemy);
                System.out.println("Commie dead");
            }
            if (inGameEnemyArray.size() == 0) { // HERE IS AN ERROR WHEN THERE IS NO ENEMY LEFT ON FIELD
                System.out.println("size 0");
                displayEndPane();
                return;
            }
        }
    }
    /** met that displays every defender **/
    private void addDefenderToGameArea() {
        gameArea.getChildren().addAll(defenderArray.get(defenderArray.size()-1).defenderRectangle);
        gameArea.getChildren().addAll(defenderArray.get(defenderArray.size()-1).defenderAttackCircle);
    }
    /** met that displays every enemy **/
    private void addEnemyToGameArea() {
        if (enemyArray.size() != 0) {
            gameArea.getChildren().addAll(enemyArray.get(0).enemyCircle);
            gameArea.getChildren().addAll(enemyArray.get(0).enemyHealthLabel);
            inGameEnemyArray.add(enemyArray.get(0));
            enemyArray.remove(0);
        }
    }
    /** met that converts the mouseposition click into a coordinate **/
    private void getMouseCoordinateClick(MouseEvent event) {
        if (buyButtonClicked) {
            Coordinate c = new Coordinate(event.getX()-250, event.getY()-170); // -250 and - 170 default (+ recktangle height and width in the Defender class)
            // System.out.println("your mouse: " + c);
            if (gameArea.contains(c.getCoordinateX(), c.getCoordinateY())) {
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
            displayEndPane();
            buyButtonClicked = false;
        }
        return;
    }
    /** met checks if the game is finished 
     * @return **/
    private void displayEndPane() {
        if (Base.getBaseHealth() < 0)
            new EndPane(1);
        if (Base.getBaseMoney() < 0)
            new EndPane(2);
        if (enemyArray.size() == 0 && inGameEnemyArray.size() == 0 && Base.getBaseHealth() > 0)
            new EndPane(3);
    }
    /** The met updates the Labels (the text Health, Money, the game description and the health of every Enemy) **/
    private void updateLabels() {
        labelBaseHealth.setText("Health: " + Base.getBaseHealth());
        labelBaseMoney.setText("$ " + Base.getBaseMoney());
        labelBuyDefenderInfo.setText("To buy defence,"
        + "\npress a button"
        + "\nin the green bx"
        + "\nthen, click on the"
        + "\nbattlefield to place"
        + "\nthe unit.");
        for (int i = 0; i < inGameEnemyArray.size(); i++)
            inGameEnemyArray.get(i).getEnemyHealthLabel().setText("" + inGameEnemyArray.get(i).getEnemyHealth());
    }
}