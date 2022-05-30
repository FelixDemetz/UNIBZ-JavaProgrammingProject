# Blood for Freedom

## 1. About

Tower Defence game by Felix Demetz and Lucas Glück.

The project consists in creating an "tower defence" videogame. The goal is to have a gaming experience in which, the user through a propper GUI, must defend a certain road (= a direction in which an element moves) by the enemy (= an element that decrements a score, if reached certain coordinates). The game ends if there is no more enemy, (means that the Base survived), if the Bases health is 0 or less, or if the Money is less then 0. Once the game is finished, the player can register with a username the score in the local scoreboard (= a txt file). We use the "JavaFX" library to emulate and display the game. The user can interact with the mouse on 2D elements displayed on the screen. 

### 1.1. Demo

Add a link to a demo of your project.

## 2. Authors

This project was created by:

Felix Demetz Student ID: 20225

Lucas Glück Stundet ID: 19084

## 3. Usage

How to compile, packege and run the project.

1. Compile via Maven:
   ```bash
   mvn compile
   ```
2. Package via Maven:
   ```bash
   mvn package
   ```
3. Run via Maven:
   ```bash
   mvn javafx:run
   ```
<!-- 4. Run your application via the jar you generate:
   ```bash
   java -jar target/ProjectLF-1.0-SNAPSHOT.jar
   ``` -->

## 4. Implementation

### 4.1. Architectural Overview

We decided to have classes for the 4 main elements of the game: Defender, Enemy, the Base and the App (running and displaying the game). Later on we added other important classes like Coordinate and Player.
We used JavaFX to create a simple but "easy to handle" GUI.

### 4.2. Third-Party Libraries

None

### 4.3. Programming Techniques

List and explain how you used the 10 programming techniques required for this project.

- **Technique 1**: We used Collections (ArrayList, arrays) to gather together many elements of the same type
- **Technique 2**: We used Custom exceptions to get informed when a file (the scoreboard.txt file) is not present or corrupt.
- **Technique 3**: We use Try-Catch blocks to read and write on a file and to throw exceptions
- **Technique 4**: We used met overriding in the Launcher.java start() met and in our custom exception class.
- **Technique 5**: We used met overriding in our custom exception class.
- **Technique 6**: We used lambda expressions to handle events mainly on buttons (setOnAction())
- **Technique 7**: We used Optionals in every Alert dialog pane, to use ButtonTypes.
- **Technique 8**: We used I/O when reading or writing on our Scoreboard.txt.
- **Technique 9**: We used regular expressions to filter certain parts of the scoreboard and then set up the best player.
- **Technique 10**: We used test hooks in testing.
- **Technique 11**: We used the graphical interface JavaFX so that the user can more easely interact with the game.

### 4.4. TODO Tests

Briefly describe and motivate your test suite.

## 5. Experience

### 5.1. Overall Experience

The implementation of a tiny story in the game, made the hours of "googleing" and the problems with JavaFX easier to handle. We noticed that sometimes one member spend hours on the implementation of a new method and just did minor progesses, and then out of nowhere the other member figured it out in some minutes. We underestimated the time needed to research and to find the right classes and techniques to implement certain behaviours.
To know that we only used the knowledge that we gained during lectures, the internet and our motivation to start form an idea in our head and than see the game working as we sketched it, fills us with joy.

### 5.2. Division of Responsibilities

- **Student Felix Demetz** I designed the game on paper, created the GUI, wrote stupid little descriptions.
- **Student Lucas Glück** Got the idea to create a TD game, to create something on which we spend hour on gaming. I was in charge to test the game.

The design of the main classes was teamjob as we both worked in the same room.
We never clearely divided responsabilities, we developed the game together, writing lines of code whenever we came up with new features and ideas.

### 5.3. Main Challenges

- **Student Felix Demetz** The most difficult part was to implement a class or a method that runs a loop evey X seconds without pressing a button (initially we added a button to move the Enemies forward but it wasn't optimal). It is difficult to search something online when you don't know what you are looking for. At the end we came up with the Timeline class (not Timer, not Time).
- **Student Lucas Glück** For me one big challange was to set up the framework in which the game is working on. You know that a program is launched with a main met, but then to add a GUI with panes in it wasn't easy.

A big challenge (for both of us) was to design the entire project, where to put a method, which classes we need, ecc. At the end we decided to have an App class (most important one) and a Base class that saves Health, Money, GameMode and so on.

### TODO 5.4. Learning Outcomes

Describe what you learned with this project.

- **Student Felix Demetz** I learned a new library called `xyz`!
- **Student Lucas Glück** I learned how to implement the design pattern `abc`