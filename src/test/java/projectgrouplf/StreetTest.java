package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

public class StreetTest { 

    @Test
    @DisplayName("Testing if best Player should have health 9 (form those 5)")
    void getBestPlayerOutOfFive() {

        Street street = new Street();
        street = street.getRandomStreet();
        int a = street.streetArray.size();
        int b = 4;
        System.out.println(a);
        assertEquals(b,  a);
   }

}