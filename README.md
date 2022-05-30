# Blood for Freedom

Tower defence "Blood for Freedom" by Felix Demetz and Lucas Glück.

This **README** contains the cmds how to run the current game source code with maven.

You can:
1. Run your application via Maven:
   ```bash
   mvn exec:java
   ```
2. Run your application via the jar you generate:
   ```bash
   java -jar target/ProjectLF-1.0-SNAPSHOT.jar
   ```

   <!-- The cmd mvn exec:exec does not execute:
   Failed to execute goal org.codehaus.mojo:exec-maven-plugin:1.1:exec (default-cli) on project ProjectLF: The parameters 'executable' for goal org.codehaus.mojo:exec-maven-plugin:1.1:exec are missing or invalid 
   
   The code can no create a proper .jar file if there is JavaFX code -->
   # Your project's title

## 1. General

Git:
We work on the "dev" branch, and bigger features are created on a "feature1++" branch.
The final version, beginning from the first release is on the "master" branch.

Game name: ? Blood for freedom


## 2. Classes

- Enemy: enemyPositionXY, enemyColor (red), enemySize, enemyDimension (the form), emenyDamage, enemyHealth,
enemyDirection (the movement or should we write this in a met?), enemyMoney,
Enemy1, 2, ...

- Defender: defenderPositionXY, defenderColor (blue) , defenderSize, enemyDimension (the form), defenderHealth, defenderDamage,
radius, radius;
Defender1, 2, ...

- "General": health, time, money
(should we call it Base?)

- Road: startXY, finishXY, turnsXY (more elements)
(should be just a strait line at first)


## 3. Methods

- start
- stop
- restart
- enemyMovement?


