/* This class launches / runns the app */
package projectgrouplf;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new App(), 1025, 450);
        primaryStage.setTitle("Blood for Freedom");
        primaryStage.setResizable(false); // should not change window size
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}