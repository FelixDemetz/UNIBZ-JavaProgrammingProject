package projectgrouplf;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class MissionInfoPane {
	
	public MissionInfoPane() {
    	Alert dialog = new Alert(AlertType.WARNING);
    	dialog.setTitle("Mission protocol");

		ButtonType backButtonType = new ButtonType("Fight!");

		dialog.getButtonTypes().setAll(backButtonType);

		if (Base.survival) { // this is the dialog that is on the Pane after the start it depends if you choose Normal or Surival
			dialog.setHeaderText("Doomsday");
			dialog.setContentText("You are the last man standing, the rest surrendered."
				+ "\n"
				+ "\nUse your wisdom to place defense units on the battlefield."
				+ "\nWith the gun lobby at your side, defend your Bases health at all cost."
				+ "\n"
				+ "\nTry not to enjoy the killing too much...");
		}
		else {
			dialog.setHeaderText("Defend our liberty!");
			dialog.setContentText("If Normandy 1944, 'Nam 1961 or Dombass 2022,"
				+ "\nWar, war never changes." // thx to InterPlay
				+ "\n"
				+ "\nYou work for the IT department in the minister of defense."
				+ "\nWith your skills you gained access to the Enemies convoy coordinates."
				+ "\nUse your wisdom to place defense units on the battlefield."
				+ "\nWith the gun lobby at your side, defend your Bases health at all cost."
				+ "\n"
				+ "\nRemember: if we don't end war, war will end freedom!");
		}
		Optional<ButtonType> result = dialog.showAndWait();
		if (result.get() == backButtonType) {
			dialog.close();
		}
	}
}
