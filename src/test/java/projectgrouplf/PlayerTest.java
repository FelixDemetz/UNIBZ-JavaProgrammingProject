package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class PlayerTest { 

    @Test
    @DisplayName("Testing if best Player should have health 9 (form those 5)")
    void getBestPlayerOutOfFive() {

        ArrayList<Player> array = new ArrayList<Player>();
        Player a1 = new Player("AaronH", 8, 30, "Normal");
        Player a2 = new Player("Fede", 1, 30, "Normal");
        Player a3 = new Player("Laurin", 4, 30, "Normal");
        Player a4 = new Player("Leo", 7, 30, "Normal");
        Player a5 = new Player("Mat", 9, 30, "Normal");
        array.add(a1);
        array.add(a2);
        array.add(a3);
        array.add(a4);
        array.add(a5);
        Player bestPlayer = Player.getBestHealthPlayer(array, true);
        assertEquals(9, bestPlayer.playerHealth);
   }

}
