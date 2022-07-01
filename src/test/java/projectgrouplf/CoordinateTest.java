package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoordinateTest { 

    @Test
    @DisplayName("Testing if returned value of the CoordinateX is the right one")
    void getCoordinateXTest() {
        Coordinate c1 = new Coordinate(10, 30);
        double coordinateX;

        coordinateX = c1.getCoordinateX();
        assertEquals(10, coordinateX);
   }

    @Test
    @DisplayName("Testing if returned value of the CoordinateY is the right one")
    void getCoordinateYTest() {
        Coordinate c1 = new Coordinate(10, 30);
        double coordinateY;

        coordinateY = c1.getCoordinateY();
        assertEquals(30, coordinateY);
   }

    @Test
    @DisplayName("Testing if you can set the CoordinateX of a Coordinate and it returns the right one.")
    void setCoordinateXTest() {
        Coordinate c1 = new Coordinate(10, 30);
        double coordinateX1= 99, coordinateX2;

        c1.setCoordinateX(coordinateX1);
        coordinateX2 = c1.getCoordinateX();
        assertEquals(99, coordinateX2);
    }

    @Test
    @DisplayName("Testing if you can set the CoordinateY of a Coordinate and it returns the right one.")
    void setCoordinateYTest() {
        Coordinate c1 = new Coordinate(10, 30);
        double coordinateY1= 99, coordinateY2;

        c1.setCoordinateY(coordinateY1);
        coordinateY2 = c1.getCoordinateY();
        assertEquals(99, coordinateY2);
    }

    @Test
    @DisplayName("Testing if the returned string of a Coordinate is right")
    void toStringTest(){
        Coordinate c1 = new Coordinate(10, 30);

        assertEquals("CordX: " + c1.getCoordinateX() + " , cordY: " + c1.getCoordinateY(), "CordX: 10.0 , cordY: 30.0");
    }
}