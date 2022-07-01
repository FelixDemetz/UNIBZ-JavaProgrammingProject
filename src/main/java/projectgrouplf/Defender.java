package projectgrouplf;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Defender {

    public Rectangle defenderRectangle;
    public Circle defenderAttackCircle;
    private Coordinate defenderCoordinate;
    private double circleRadius = 0;
    private int defenderDamage = 0;

    public Defender(Coordinate defenderCoordinate, int defenderRank) {
        this.defenderCoordinate = defenderCoordinate;
        this.defenderRectangle = new Rectangle(defenderCoordinate.getCoordinateX(), defenderCoordinate.getCoordinateY(), 50, 50);
        this.defenderAttackCircle = new Circle(defenderCoordinate.getCoordinateX() + defenderRectangle.getWidth()/2, defenderCoordinate.getCoordinateY()+ defenderRectangle.getHeight()/2, circleRadius);
        this.defenderRectangle.setFill(Color.BLUE);
        this.defenderAttackCircle.setFill(Color.rgb(30, 30, 100, 0.1));
        setDefenderRank(defenderRank);
    }

    /** This is the most important met for the Defender it defines the rank (damage, health and size) */
    private Defender setDefenderRank(int defenderRank) {
        if (defenderRank == 1) {
            this.setDefenderDamage(1);
            this.defenderRectangle.setWidth(20);
            this.defenderRectangle.setHeight(20);
            this.defenderAttackCircle.setRadius(30);
        }
        if (defenderRank == 2) {
            this.setDefenderDamage(2);
            this.defenderRectangle.setWidth(30);
            this.defenderRectangle.setHeight(30);
            this.defenderAttackCircle.setRadius(50);
        }
        if (defenderRank == 3) {
            this.setDefenderDamage(3);
            this.defenderRectangle.setWidth(50);
            this.defenderRectangle.setHeight(50);
            this.defenderAttackCircle.setRadius(75);
        } // have to change the coordinates in base of the heigth and width
        setDefenderCoordinate(this.defenderCoordinate);
        return this;
    }

    public Coordinate getDefenderCoordinate() {
        return defenderCoordinate;
    }
    public int getDefenderDamage() {
        return defenderDamage;
    }
    public void setDefenderDamage(int defenderDamage) {
        this.defenderDamage =  defenderDamage;
    }

    /** The met has as parameter a new Coordinate() which is the new coordinate of the defender, sets the recktangle and the attackCircle **/
    private void setDefenderCoordinate(Coordinate defenderCoordinate) {
        this.defenderRectangle.setX(defenderCoordinate.getCoordinateX() - this.defenderRectangle.getWidth() / 2);
        this.defenderRectangle.setY(defenderCoordinate.getCoordinateY() - this.defenderRectangle.getHeight() / 2);
        this.defenderAttackCircle.setCenterX(this.defenderCoordinate.getCoordinateX());
        this.defenderAttackCircle.setCenterY(this.defenderCoordinate.getCoordinateY());
    }
    
}
