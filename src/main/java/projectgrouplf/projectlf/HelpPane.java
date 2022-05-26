
package projectgrouplf.projectlf;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class HelpPane {
	
	HelpPane() {
    	Alert dialog = new Alert(AlertType.INFORMATION);
    	dialog.setTitle("Game Guide");
    	dialog.setHeaderText("the header text says: pls no press X btn");
		dialog.setGraphic(null);

		ButtonType backButtonType = new ButtonType("OK");

		dialog.getButtonTypes().setAll(backButtonType);

    	dialog.setContentText("Here is a short guide how to defend \"Blues\" freedom");
		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == backButtonType) {
			dialog.close();
		}
	}
}
