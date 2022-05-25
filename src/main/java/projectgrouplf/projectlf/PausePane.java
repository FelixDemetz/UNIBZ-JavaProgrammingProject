
package projectgrouplf.projectlf;

import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class PausePane {

	public PausePane() {
		Alert dialog = new Alert(AlertType.INFORMATION);
    	dialog.setTitle("Pause");
    	dialog.setHeaderText(null);
		dialog.setGraphic(null);
		
		ButtonType continueButtonType = new ButtonType("Continue");
		ButtonType restartButtonType = new ButtonType("Restart");
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
			// reset copiet form the App class
			// Base.survivalOrNormalBaseHealt();
			// Base.setBaseMoney(100);
            // defenderArray.clear();
            // inGameEnemyArray.clear();
            // enemyArray.clear();
            // enemyArray.addAll(copyOfenemyArray);
            // afterTreeBtnPressesMove = 0;
            // buttonPressCounter = 0;

			System.out.println("Should restart btn is clicked");
		}
	}
}
