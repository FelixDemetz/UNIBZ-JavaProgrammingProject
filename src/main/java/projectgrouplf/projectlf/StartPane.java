
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
		// dialog.getDialogPane().setPrefSize(200, 100);
		
		ButtonType playButtonType = new ButtonType("Play");
		ButtonType playSurvivalButtonType = new ButtonType("Play Survival");
		ButtonType helpButtonType = new ButtonType("Help");
		ButtonType quitButtonType = new ButtonType("Quit");

		dialog.getButtonTypes().setAll(playButtonType, playSurvivalButtonType, quitButtonType);
		dialog.setContentText("Tower defence game by Felix Demetz and Lucas Glick \n\n v 1.0 \n");
		

		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == playButtonType) {
			dialog.close();
			new MissionInfoPane();
		}
		if (result.get() == playSurvivalButtonType) {
			//dialog.close();
			Base.survival = true;
			new MissionInfoPane();
			}
		if (result.get() == helpButtonType) {
			new HelpPane();
			new StartPane();
		}
		if (result.get() == quitButtonType) {
			Platform.exit();
		}
	}
}