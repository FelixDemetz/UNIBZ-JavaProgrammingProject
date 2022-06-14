package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

/* Tests the movement and creating an array with the number of Enemies desiderated */
class EnemyTest {
    Coordinate endingPoint = new Coordinate(200, 200);
    Coordinate startingPoint = new Coordinate(0, 0);
    Enemy testEnemy;
    int totalEnemyRanks = 3;

    // tests if setNewEnemyArray() works
    @Test
    @DisplayName("Testing if the setNewEnemyArray() creates 100 Enemies")
    void setNewEnemyArrayHasCertainSize() {
        ArrayList<Enemy> array= Enemy.setNewEnemyArray(100, totalEnemyRanks);
        assertEquals(100, array.size());
    }

    // tests if checkIfEnemyReachedBase() works
    @Test
    @DisplayName("Testing if the checkIfEnemyReachedBase() gives true if enemy surpassed endingPoint")
    void checkIfEnemyReachedBaseTester() {
        testEnemy = new Enemy(startingPoint, 3);
        assertEquals(false, testEnemy.checkIfEnemyReachedBase(endingPoint));
    }


    /** The next test mets tests if the enemyMovesForward() met works correctly with different coordinates and Enemy rank types 
     *  Testet the Enemy coordinate, the Enemy circle and the Enemy text.
    */

    // Enemy rank 1

    // moves by X0 Y0
    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving to the right has the right coordinates")
    void enemyMovesRank1Right0() {
        Coordinate shouldBeThere = new Coordinate(0, 0);
        int rank = 1;
        testEnemy = new Enemy(shouldBeThere, rank);
        testEnemy.enemyMovesForward(0, endingPoint);   
        assertEquals(shouldBeThere.toString(), testEnemy.getEnemyCoordinate().toString());
    }

    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving to the right has the right coordinates")
    void enemyMovesRank1Right5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(5, 0);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(0);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.toString(), testEnemy.getEnemyCoordinate().toString());
    }

    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving to the Left has the right coordinates")
    void enemyMoveRank1Left5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(-5, 0);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(2);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.toString(), testEnemy.getEnemyCoordinate().toString());
    }

    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving to the Up has the right coordinates")
    void enemyMoveRank1Up5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(0, -5);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(1);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.toString(), testEnemy.getEnemyCoordinate().toString());
    }

    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving to the Down has the right coordinates")
    void enemyMoveRank1Down5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(0, 5);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(-1);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.toString(), testEnemy.getEnemyCoordinate().toString());
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyCircleMoveRank1Down5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(0, 5);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(-1);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyCircle.getCenterY());
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyCircleMoveRank1Up5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(0, -5);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(1);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyCircle.getCenterY());
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyCircleMoveRank1Left5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(-5, 0);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(2);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyCircle.getCenterY());
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyCircleMoveRank1Right5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(5, 0);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(0);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyCircle.getCenterY());
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyHEalthTextMoveRank1Right5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(5, 0);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(0);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyHealthText.getX() +5);
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyHealthText.getY() -5);
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyHEalthTextMoveRank1Left5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(-5, 0);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(2);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyHealthText.getX() +5);
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyHealthText.getY() -5);
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyHEalthTextMoveRank1Up5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(0, -5);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(1);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyHealthText.getX() +5);
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyHealthText.getY() -5);
    }

    @Test
    @DisplayName("Testing if the Enemy.healthText (rank 1) after moving to the Down has the right coordinates")
    void enemyHEalthTextMoveRank1Down5() {
        Coordinate enemyStartCord= new Coordinate(0, 0);
        Coordinate shouldBeThere = new Coordinate(0, 5);
        int rank = 1;
        testEnemy = new Enemy(enemyStartCord, rank);
        testEnemy.setEnemyDirection(-1);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeThere.getCoordinateX(), testEnemy.enemyHealthText.getX() +5);
        assertEquals(shouldBeThere.getCoordinateY(), testEnemy.enemyHealthText.getY() -5);
    }

}