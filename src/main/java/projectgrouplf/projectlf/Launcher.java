/* This class launches / runns the app */
package projectgrouplf.projectlf;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public void start(Stage primaryStage) {
        Scene scene = new Scene(new App(), 1150, 450);
        //primaryStage.setMaximized(true); // so the window is fullscreen
        primaryStage.setTitle("Blood for Freedom");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}