
package projectgrouplf;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class HelpPane {
	
	HelpPane() {
    	Alert dialog = new Alert(AlertType.INFORMATION);
    	dialog.setTitle("Game Guide");
    	dialog.setHeaderText("Quide");
		dialog.setGraphic(null);

		ButtonType backButtonType = new ButtonType("OK");

		dialog.getButtonTypes().setAll(backButtonType);
		System.out.println("please pause");
    	dialog.setContentText("This is a Tower Defence Game."
		+"\n"
		+"\nAvoid that Enemies reach your Base (= right side of the screen). Enemies will move from left to right on the street (= black line). Buy Defense from the military industry, by clicking on the buttons in the green field. After you clicked on the button click on the field where you want to place the Defender."
		+"\n"
		+"\nSurvival is a hardcore mode, your Base has only one Health, if any Enemy enters the Base, you will lose.");
		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == backButtonType) {
			dialog.close();
		}
	}
}
