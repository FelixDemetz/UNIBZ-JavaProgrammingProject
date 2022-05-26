
package projectgrouplf.projectlf;

import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class EndPane {
	
	EndPane(int endNr) {
    	Alert dialog = new Alert(AlertType.INFORMATION);
    	dialog.setTitle("Game Finished");
        dialog.setGraphic(null);

		ButtonType restartButtonType = new ButtonType("Restart");
		ButtonType quitButtonType = new ButtonType("Quit");

		dialog.getButtonTypes().setAll(restartButtonType, quitButtonType);

        switch(endNr) {
            case 1: // no more Base Health
                dialog.setHeaderText("You Lost!");
                dialog.setContentText("Your Base was eradicated and those who still live would prefer dead over this hell"
                    + "\n"
                    + "Enemys newspaper:"
                    + "\nMission: \"ethnic cleansing accomplished!\""
                    + "\n");
                break;
            case 2: // no more Base Money
                dialog.setHeaderText("You Lost!");
                dialog.setContentText("Oh no, the War Industry prefers money over the flag"
                    + "\n"
                    + "\nThe military corporations have switched the turntables and will now defend anothers freedom..."
                    + "\n");
                break;
            case 3: // no more Enemies
                dialog.setHeaderText("You Won?");
                dialog.setContentText("No more Enemy, no more Red, just Blue flags everywere, everybody is happy"
                    + "\n"
                    + "\nAs the days passes on, you slowly start to doubt"
                    + "\nwho was the Defender and who the Enemy,"
                    + "\nwho was the invador and who the victim,"
                    + "\nwho is the good and who is the bad one."
                    + "\nbut \"the winner is always right\", or isn't it..."
                    + "\n");
                break;
          }
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == quitButtonType) {
            Platform.exit();
        }
        if (result.get() == restartButtonType) {
            System.out.println("Should restart btn is clicked");
            // new Game()?
        }
	}
}
