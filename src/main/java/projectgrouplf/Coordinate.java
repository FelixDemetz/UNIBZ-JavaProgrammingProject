package projectgrouplf;

public class Coordinate {

	private double coordinateX, coordinateY; // we should not access this data directly only through mets
	/** -1 for down 1 for up 0 for right and 2 for left */
	public double enemyDirection;

	public Coordinate(double coordinateX, double coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	public Coordinate(double coordinateX, double coordinateY, double enemyDirection) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.enemyDirection = enemyDirection;
	}

    // Getters
	public double getCoordinateX() {
		return this.coordinateX; 
	}
	public double getCoordinateY() {
		return this.coordinateY; 
	}

    // Setters
	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX; 
	}
	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY; 
	}
	public String toString() {
		return new String("CordX: " + this.coordinateX + " , CordY: " + this.coordinateY);
	}

}
