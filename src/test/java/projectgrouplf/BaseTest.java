package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BaseTest {

   @Test
   // @DisplayName("Testing if [rick, morty, birdperson, gearhead, summer, jerry, beth] returns 24")
   void baseGameModeShouldReturnSurvival() {
      Base.survival = true;
      String survival = Base.getBaseGameMode();
      assertEquals(survival, new String("Survival"));
   }

   @Test
   void baseGameModeShouldReturnNormal() {
      Base.survival = false;
      String survival = Base.getBaseGameMode();
      assertEquals(survival, new String("Normal"));
   }

   @Test
   @DisplayName("Testing if the try catch does not return String named readUserScoreBoardFailed, as the string is initially called")
   void baseReadUserScoreBoardShouldNotReturnError() {
      String notError = Base.readUserScoreBoard();
      assertNotEquals(notError, new String("readUserScoreBoardFailed"));
   }
}