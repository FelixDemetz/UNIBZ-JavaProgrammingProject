
package projectgrouplf.projectlf;

import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class StartPane {

	public StartPane() {
		Alert dialog = new Alert(AlertType.INFORMATION);
    	dialog.setTitle("Launcher");
    	dialog.setHeaderText("Blood for Freedom");
		dialog.setGraphic(null);
		
		ButtonType continueButtonType = new ButtonType("Play");
		ButtonType restartButtonType = new ButtonType("Play Survival");
		ButtonType helpButtonType = new ButtonType("Help");
		ButtonType quitButtonType = new ButtonType("Quit");

		dialog.getButtonTypes().setAll(continueButtonType, restartButtonType, helpButtonType, quitButtonType);

		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == quitButtonType) {
			Platform.exit();
		}
		if (result.get() == continueButtonType) {
			System.out.println("Continue btn is clicked");
			dialog.close();
		}
		if (result.get() == helpButtonType) {
			new HelpPane();
			new PausePane();
		}
		if (result.get() == restartButtonType) {
			System.out.println("Should restart btn is clicked");
			// new App(); ??
		}
	}
}
