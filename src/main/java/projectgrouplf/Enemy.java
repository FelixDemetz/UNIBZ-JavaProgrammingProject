package projectgrouplf;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class Enemy {

    public Circle enemyCircle;
    public Text enemyHealthText = new Text("");
    public Coordinate enemyCoordinate;
    private double enemyDirection = 0;
    private int enemyDamage = 0;
    private int enemyHealth = 0;
    private int enemyMoney = 0;

    /** enemyRank is 1, 2 or 3, the size, health, money and damage increases */
    public Enemy(Coordinate enemyCoordinate, int enemyRank) {
        this.enemyCoordinate = enemyCoordinate;
        this.enemyCircle = new Circle(enemyCoordinate.getCoordinateX(), enemyCoordinate.getCoordinateY(), 25);
        this.enemyCircle.setFill(Color.RED); // should allways be a commie :)
        this.enemyHealthText.setFill(Color.YELLOW);
        setEnemyRank(enemyRank);
    }
    

    /** This is the most important met for the Enemy it defines the rank (damage, health, money and size) **/
    private Enemy setEnemyRank(int enemyRank) {
        if (enemyRank == 1) {
            this.setEnemyDamage(1);
            this.setEnemyHealth(4);
            this.setEnemyMoney(15);
            this.setEnemyCircle(10);
        }
        if (enemyRank == 2) {
            this.setEnemyDamage(2);
            this.setEnemyHealth(6);
            this.setEnemyMoney(30);
            this.setEnemyCircle(15);
        }
        if (enemyRank == 3) {
            this.setEnemyDamage(4);
            this.setEnemyHealth(8);
            this.setEnemyMoney(50);
            this.setEnemyCircle(20);
        }
        return this;
    }

    // Getters
    public Coordinate getEnemyCoordinate() {
        return enemyCoordinate;
    }
    public int getEnemyDamage() {
        return enemyDamage;
    }
    public int getEnemyHealth() {
        return enemyHealth;
    }
    public int getEnemyMoney() {
        return enemyMoney;
    }
    public Text getEnemyHealthText() {
        return enemyHealthText;
    }

    public double getEnemyDirection() {
        return enemyDirection;
    }
    
    // Setters

    /** Static met adds to an array the number of enemies. Paramters: the first is for the number of Enemies in the array, the 2. is for the Coordinate of every Enemy in the array and 3. is the number of possible enemy Ranks*/
    public static ArrayList<Enemy> setNewEnemyArray(int numberOfEnemiesInArray, int numberOfEnemyRanks) {
        ArrayList<Enemy> initialEnemyArray = new ArrayList<Enemy>();
        for (int i = 0; i < numberOfEnemiesInArray; i++) {
            int enemyRank = new Random().nextInt(numberOfEnemyRanks)+1;
            initialEnemyArray.add(new Enemy(App.startingCord, enemyRank));
        } 
        return initialEnemyArray;
    }
    
    /** Sets the coordinates for every Enemy element: new Coordinate, Circle, HealthText, this met is needed in enemyMovesForward met */
    private void setEnemyCoordinate(Coordinate enemyCoordinate) {
        this.enemyCoordinate =  enemyCoordinate;
        this.enemyCircle.setCenterX(enemyCoordinate.getCoordinateX());
        this.enemyCircle.setCenterY(enemyCoordinate.getCoordinateY());
        this.enemyHealthText.setX(enemyCoordinate.getCoordinateX() - 5);
        this.enemyHealthText.setY(enemyCoordinate.getCoordinateY() + 5);
    }

    /** Sets the coordinates for met setEnemyCoordinates met, the direction should be up, down, left or right */
    public void enemyMovesForward(double movementInPixel, Coordinate endingPoint) {
        boolean enemyNotReachedEnd = this.getEnemyCoordinate().getCoordinateX() < endingPoint.getCoordinateX()+this.enemyCircle.getRadius();
        double direction = getEnemyDirection();
        if (enemyNotReachedEnd) {
            double movementX = 0;
            double movementY = 0;
            if (direction == -1) {
                movementX = 0;
                movementY = movementInPixel;
            }
            if (direction == 1) {
                movementX = 0;
                movementY = - movementInPixel; // minus
            }
            if (direction == 0) {
                movementX = movementInPixel;
                movementY = 0;
            }
            if (direction == 2) {
                movementX = - movementInPixel; // minus
                movementY = 0;
            }
            Coordinate c = new Coordinate(this.enemyCoordinate.getCoordinateX() + movementX, this.enemyCoordinate.getCoordinateY() + movementY);
            this.setEnemyCoordinate(c);
        }
    }

    /** Checks if Enemy has reached endingPoint, (cordX of Enemy is bigger than cordX of endingPoint). If true damages Base */
    public boolean checkIfEnemyReachedBase(Coordinate endingPoint) {
        boolean b = false;
        if (this.getEnemyCoordinate().getCoordinateX() > endingPoint.getCoordinateX()) { // for every Enemy that is after the finish get damage, remove
            Base.setBaseHealth(Base.getBaseHealth() -this.getEnemyDamage());
            b = true;
        }
        return b;
    }

    public void setEnemyDamage(int enemyDamage) {
        this.enemyDamage =  enemyDamage;
    }
    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth =  enemyHealth;
    }
    public void setEnemyMoney(int enemyMoney) {
        this.enemyMoney =  enemyMoney;
    }
    public void setEnemyCircle(double radius) {
        this.enemyCircle.setRadius(radius);
    }
    public void deleteEnemyText() {
        this.enemyHealthText.setText("");
    }
    public void setEnemyDirection(double enemyDirection) {
        this.enemyDirection = enemyDirection;
    }
    
}
