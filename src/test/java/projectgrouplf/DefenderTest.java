package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefenderTest { 

    @Test
    @DisplayName("Testing if coordinates of a Defender are the correct ones")
    void defenderCoordinatesShouldBeRight() {

        Coordinate c = new Coordinate(12, 12);
        Defender d = new Defender(c, 2);
        assertEquals(c, d.getDefenderCoordinate());
   }

   @Test
   @DisplayName("Testing if Defenders damage can be changed")
   void defenderChangeDefenderDamage() {

       Coordinate c = new Coordinate(12, 12);
       Defender d = new Defender(c, 2);
       d.setDefenderDamage(200);
       assertEquals(200, d.getDefenderDamage());
  }
}
