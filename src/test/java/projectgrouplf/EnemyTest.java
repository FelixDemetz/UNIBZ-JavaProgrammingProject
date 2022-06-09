package projectgrouplf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

/* Tests the movement and creating an array with the number of Enemies desiderated */
class EnemyTest {
    Coordinate endingPoint = new Coordinate(200, 200);
    Enemy testEnemy;
    int totalEnemyRanks = 3;

    // tests if setNewEnemyArray() works
    @Test
    @DisplayName("Testing if the setNewEnemyArray() creates 100 Enemies")
    void setNewEnemyArrayHasCertainSize() {
        ArrayList<Enemy> array= Enemy.setNewEnemyArray(100, c, totalEnemyRanks);
        assertEquals(100, array.size());
    }


    /** The next test mets test if the enemyMovesForward() met works correctly with different coordinates and Enemy rank types 
     *  Testet the Enemy coordinate, the Enemy circle and the Enemy text.
    */

    // Enemy rank 1

    // moves by X0 Y0
    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving x 0 and y 0 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveX0Y0() {
        int shouldBeCordX = 0;
        int shouldBeCordY = 0;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0,0, 0), rank);
        testEnemy.enemyMovesForward(5, endingPoint);   
        assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
        assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    }
    @Test
    @DisplayName("Testing if the circle of Enemy (rank 1) after moving x 0 and y 0 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveCircleX0Y0() {
        int shouldBeCordX = 0;
        int shouldBeCordY = 0;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(0, 0, c);   
        assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    }
    @Test
    @DisplayName("Testing if the text of Enemy (rank 1) after moving x 0 and y 0 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveTextX0Y0() {
        int shouldBeCordX = 0;
        int shouldBeCordY = 0;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(0, 0, c);   
        assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
        assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    }
    // moves by X1 Y1
    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving x 1 and y 0 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveX1Y1() {
        int shouldBeCordX = 1;
        int shouldBeCordY = 0;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(shouldBeCordX, 0, c);   
        assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
        assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    }
    @Test
    @DisplayName("Testing if the circle of Enemy (rank 1) after moving x 0 and y 1 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveCircleX1Y1() {
        int shouldBeCordX = 1;
        int shouldBeCordY = 0;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(shouldBeCordX, 0, c);     
        assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    }
    @Test
    @DisplayName("Testing if the text of Enemy (rank 1) after moving x 1 and y 0 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveTextX1Y1() {
        int shouldBeCordX = 1;
        int shouldBeCordY = 0;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(shouldBeCordX, 0, c);     
        assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
        assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    }
    // moves by X10 Y10
    @Test
    @DisplayName("Testing if the Enemy (rank 1) after moving x 0 and y 10 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveX10Y10() {
        int shouldBeCordX = 0;
        int shouldBeCordY = 10;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(shouldBeCordY, -1, c);   
        assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
        assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    }
    @Test
    @DisplayName("Testing if the circle of Enemy (rank 1) after moving x 0 and y 10 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveCircleX10Y10() {
        int shouldBeCordX = 0;
        int shouldBeCordY = 10;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(shouldBeCordY, -1, c);   
        assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
        assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    }
    @Test
    @DisplayName("Testing if the text of Enemy (rank 1) after moving x 0 and y 10 has the right coordinates")
    void enemyRank1MovesForwardShouldMoveTextX10Y10() {
        int shouldBeCordX = 0;
        int shouldBeCordY = 10;
        int rank = 1;
        testEnemy = new Enemy(new Coordinate(0, 0), rank);
        testEnemy.enemyMovesForward(shouldBeCordY, -1, c);   
        assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
        assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    }
    // // moves by X-5 Y25
    // @Test
    // @DisplayName("Testing if the Enemy (rank 1) after moving x -5 and y 25 has the right coordinates")
    // void enemyRank1MovesForwardShouldMoveMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 1;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 1) after moving x -5 and y 25 has the right coordinates")
    // void enemyRank1MovesForwardShouldMoveCircleMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 1;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 1) after moving x -5 and y 25 has the right coordinates")
    // void enemyRank1MovesForwardShouldMoveTextMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 1;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }

    // // moves by X-5 Y-25
    // @Test
    // @DisplayName("Testing if the Enemy (rank 1) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank1MovesForwardShouldMoveMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 1;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 1) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank1MovesForwardShouldMoveCircleMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 1;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 1) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank1MovesForwardShouldMoveTextMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 1;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }

    // // Enemy rank 2
    // // moves by X0 Y0
    // @Test
    // @DisplayName("Testing if the Enemy (rank 2) after moving x 0 and y 0 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveX0Y0() {
    //     int shouldBeCordX = 0;
    //     int shouldBeCordY = 0;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 2) after moving x 0 and y 0 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveCircleX0Y0() {
    //     int shouldBeCordX = 0;
    //     int shouldBeCordY = 0;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 2) after moving x 0 and y 0 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveTextX0Y0() {
    //     int shouldBeCordX = 0;
    //     int shouldBeCordY = 0;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    // // moves by X1 Y1
    // @Test
    // @DisplayName("Testing if the Enemy (rank 2) after moving x 1 and y 1 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveX1Y1() {
    //     int shouldBeCordX = 1;
    //     int shouldBeCordY = 1;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 2) after moving x 1 and y 1 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveCircleX1Y1() {
    //     int shouldBeCordX = 1;
    //     int shouldBeCordY = 1;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 2) after moving x 1 and y 1 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveTextX1Y1() {
    //     int shouldBeCordX = 1;
    //     int shouldBeCordY = 1;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    // // moves by X10 Y10
    // @Test
    // @DisplayName("Testing if the Enemy (rank 2) after moving x 10 and y 10 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveX10Y10() {
    //     int shouldBeCordX = 10;
    //     int shouldBeCordY = 10;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 2) after moving x 10 and y 10 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveCircleX10Y10() {
    //     int shouldBeCordX = 10;
    //     int shouldBeCordY = 10;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 2) after moving x 10 and y 10 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveTextX10Y10() {
    //     int shouldBeCordX = 10;
    //     int shouldBeCordY = 10;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    // // moves by X-5 Y25
    // @Test
    // @DisplayName("Testing if the Enemy (rank 2) after moving x -5 and y 25 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 2) after moving x -5 and y 25 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveCircleMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 2) after moving x -5 and y 25 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveTextMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }

    // // moves by X-5 Y-25
    // @Test
    // @DisplayName("Testing if the Enemy (rank 2) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 2) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveCircleMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 2) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank2MovesForwardShouldMoveTextMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 2;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }

    // // Enemy rank 3
    // // moves by X0 Y0
    // @Test
    // @DisplayName("Testing if the Enemy (rank 3) after moving x 0 and y 0 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveX0Y0() {
    //     int shouldBeCordX = 0;
    //     int shouldBeCordY = 0;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 3) after moving x 0 and y 0 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveCircleX0Y0() {
    //     int shouldBeCordX = 0;
    //     int shouldBeCordY = 0;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 3) after moving x 0 and y 0 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveTextX0Y0() {
    //     int shouldBeCordX = 0;
    //     int shouldBeCordY = 0;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    // // moves by X1 Y1
    // @Test
    // @DisplayName("Testing if the Enemy (rank 3) after moving x 1 and y 1 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveX1Y1() {
    //     int shouldBeCordX = 1;
    //     int shouldBeCordY = 1;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 3) after moving x 1 and y 1 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveCircleX1Y1() {
    //     int shouldBeCordX = 1;
    //     int shouldBeCordY = 1;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 3) after moving x 1 and y 1 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveTextX1Y1() {
    //     int shouldBeCordX = 1;
    //     int shouldBeCordY = 1;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    // // moves by X10 Y10
    // @Test
    // @DisplayName("Testing if the Enemy (rank 3) after moving x 10 and y 10 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveX10Y10() {
    //     int shouldBeCordX = 10;
    //     int shouldBeCordY = 10;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 3) after moving x 10 and y 10 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveCircleX10Y10() {
    //     int shouldBeCordX = 10;
    //     int shouldBeCordY = 10;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 3) after moving x 10 and y 10 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveTextX10Y10() {
    //     int shouldBeCordX = 10;
    //     int shouldBeCordY = 10;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    // // moves by X-5 Y35
    // @Test
    // @DisplayName("Testing if the Enemy (rank 3) after moving x -5 and y 35 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 3) after moving x -5 and y 35 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveCircleMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 3) after moving x -5 and y 35 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveTextMinus5Y25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = 25;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }

    // // moves by X-5 Y-25
    // @Test
    // @DisplayName("Testing if the Enemy (rank 3) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.getEnemyCoordinate().getCoordinateX());
    //     assertEquals(shouldBeCordY, testEnemy.getEnemyCoordinate().getCoordinateY());
    // }
    // @Test
    // @DisplayName("Testing if the circle of Enemy (rank 3) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveCircleMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyCircle.getCenterX());
    //     assertEquals(shouldBeCordY, testEnemy.enemyCircle.getCenterY());
    // }
    // @Test
    // @DisplayName("Testing if the text of Enemy (rank 3) after moving x -5 and y -25 has the right coordinates")
    // void enemyRank3MovesForwardShouldMoveTextMinus5YMinus25() {
    //     int shouldBeCordX = -5;
    //     int shouldBeCordY = -25;
    //     int rank = 3;
    //     testEnemy = new Enemy(new Coordinate(0, 0), rank);
    //     testEnemy.enemyMovesForward(0, 0, c);   
    //     assertEquals(shouldBeCordX, testEnemy.enemyHealthText.getX() + 5);
    //     assertEquals(shouldBeCordY, testEnemy.enemyHealthText.getY() - 5);
    // }
    
}