/* This class launches / runns the app */
package projectgrouplf.projectlf;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public void start(Stage primaryStage) {
        Scene scene = new Scene(new App(), 1600, 900);
        primaryStage.setTitle("Blood for Freedom - by Felix Demetz and Lucas Glück");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}