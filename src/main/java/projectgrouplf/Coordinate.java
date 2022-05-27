package projectgrouplf;

public class Coordinate {

	private double coordinateX, coordinateY; // we should not access this data directly only through mets
	
	public Coordinate(double coordinateX, double coordinateY) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
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
		return new String("CordX: " + this.coordinateX + " , cordY: " + this.coordinateY);
	}

}
