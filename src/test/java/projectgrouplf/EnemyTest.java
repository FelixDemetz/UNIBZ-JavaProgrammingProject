package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestEngine;

import javafx.scene.shape.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EnemyTest {

    Coordinate c = new Coordinate(0, 0);
    Rectangle endingPoint = new Rectangle(0, 0, 5, 5);
    Enemy testEnemy = new Enemy(c, 1);

   @Test
   @DisplayName("Testing if the Enemy moves in one direction")
   void enemyMovesForwardShouldMove() {
        testEnemy.enemyMovesForward(5, endingPoint);   
    assertEquals(testEnemy.getEnemyCoordinate(), new Coordinate(5, 0));
   }
}