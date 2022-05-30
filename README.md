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