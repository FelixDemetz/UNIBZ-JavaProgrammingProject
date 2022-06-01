package projectgrouplf;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Enemy {

    public Circle enemyCircle;
    public Text enemyHealthText = new Text("");
    public Coordinate enemyCoordinate;
    private int enemyDamage = 0;
    private int enemyHealth = 0;
    private int enemyMoney = 0;

    /** enemyRank is 1, 2 or 3, the site, health, money and damage increases */
    public Enemy(Coordinate enemyCoordinate, int enemyRank) {
        this.enemyCoordinate = enemyCoordinate;
        this.enemyCircle = new Circle(enemyCoordinate.getCoordinateX(), enemyCoordinate.getCoordinateY(), 25);
        this.enemyCircle.setFill(Color.RED); // should allways be a commie :)
        this.enemyHealthText.setFill(Color.YELLOW);
        // this.enemyHealthText.setLayoutX(enemyCoordinate.getCoordinateX() - this.enemyHealthText.getX());
        // this.enemyHealthText.setLayoutY(enemyCoordinate.getCoordinateY() - this.enemyHealthText.getY());

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
    // Setters
    /** Sets the coordinates for every Enemy element: new Coordinate, Circle, HealthText, this met is needed in enemyMovesForward met */
    private void setEnemyCoordinate(Coordinate enemyCoordinate) {
        this.enemyCoordinate =  enemyCoordinate;
        this.enemyCircle.setCenterX(enemyCoordinate.getCoordinateX());
        this.enemyCircle.setCenterY(enemyCoordinate.getCoordinateY());
        this.enemyHealthText.setX(enemyCoordinate.getCoordinateX() - 5);
        this.enemyHealthText.setY(enemyCoordinate.getCoordinateY() + 5);
    }

    /** Sets the coordinates for met setEnemyCoordinates met */
    public void enemyMovesForward(Coordinate newCord, Rectangle endingPoint) {
        boolean enemyNotReachedEnd = this.getEnemyCoordinate().getCoordinateX() < endingPoint.getX()+this.enemyCircle.getRadius();
        if (enemyNotReachedEnd) {
            this.setEnemyCoordinate(new Coordinate(this.enemyCoordinate.getCoordinateX() + newCord.getCoordinateX(), this.enemyCoordinate.getCoordinateY() + newCord.getCoordinateY()));
        }
    }

    /** Checks if Enemy has reached endingPoint, (cordX of Enemy is bigger than cordX of endingPoint). If true damages Base */
    public boolean checkIfEnemyReachedBase(Rectangle endingPoint) {
        boolean b = false;
        if (this.getEnemyCoordinate().getCoordinateX() > endingPoint.getX()) { // for every Enemy that is after the finish get damage, remove
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
    
}
