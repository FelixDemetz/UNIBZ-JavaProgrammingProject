package projectgrouplf.projectlf;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Enemy {

    public Circle enemyCircle;
    public Label enemyHealthLabel;
    private Coordinate enemyCoordinate;
    private int enemyDamage = 1;
    private int enemyHealth = 10;
    private int enemyMoney = 15;

    public Enemy(Coordinate enemyCoordinate, int enemyRank) {
        this.enemyCoordinate = enemyCoordinate;
        this.enemyCircle = new Circle(enemyCoordinate.getCoordinateX(), enemyCoordinate.getCoordinateY(), 25);
        this.enemyCircle.setFill(Color.RED); // should allways be a commie :)
        this.enemyHealthLabel = new Label();
        this.enemyHealthLabel.setTextFill(Color.YELLOW);
        this.enemyHealthLabel.setLayoutX(enemyCoordinate.getCoordinateX() - this.enemyHealthLabel.getWidth());
        this.enemyHealthLabel.setLayoutY(enemyCoordinate.getCoordinateY() - this.enemyHealthLabel.getHeight());
        setEnemyRank(enemyRank);
    }

    /** This is the most important met for the enemy it defines the rank (damage, health, money and size) **/
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
    public Label getEnemyHealthLabel() {
        return enemyHealthLabel;
    }
    // Setters
    /** The met has as parameter a new Coordinate() which is the new coordinate of the enemy, sets the circle **/
    private void setEnemyCoordinate(Coordinate enemyCoordinate) {
        this.enemyCoordinate =  enemyCoordinate;
        this.enemyCircle.setCenterX(enemyCoordinate.getCoordinateX());
        this.enemyCircle.setCenterY(enemyCoordinate.getCoordinateY());
    }
    public void enemyMovesForward(Rectangle endingPoint, Label labelBaseHealth) {
        boolean enemyNotReachedEnd = this.getEnemyCoordinate().getCoordinateX() < endingPoint.getX()+this.enemyCircle.getRadius();
        if (enemyNotReachedEnd) {// not reached and sec passes
            // SHOULD WE WORK HERE WITH TRANSITIONS?
            this.setEnemyCoordinate(new Coordinate(this.enemyCoordinate.getCoordinateX() + 40, this.enemyCoordinate.getCoordinateY()));
            this.enemyHealthLabel.setLayoutX(enemyCoordinate.getCoordinateX() - this.enemyHealthLabel.getWidth()/2);
            this.enemyHealthLabel.setLayoutY(enemyCoordinate.getCoordinateY() - this.enemyHealthLabel.getHeight()/2);
        }
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
    public void deleteEnemyLabel() {
        this.enemyHealthLabel.setText("");
    }
    
}
