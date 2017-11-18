package weightAppUI.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class AppAlert extends Alert {

    public AppAlert(AlertType alertType, String title, String description) {
        super(alertType, null, ButtonType.APPLY, ButtonType.CANCEL);
        customAlert(title, description);
    }

    private void customAlert(String title, String description) {
        this.setContentText(description);
        this.setTitle(title);
    }
}
