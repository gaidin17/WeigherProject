package weighAppUI.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AppAlert extends Alert {

    private ButtonType apply = new ButtonType("ДА", ButtonBar.ButtonData.OK_DONE);
    private ButtonType cancel = new ButtonType("НЕТ", ButtonBar.ButtonData.CANCEL_CLOSE);

    public AppAlert(AlertType alertType, String title, String contentTitle, String description) {
        super(alertType);
        customAlert(title, contentTitle, description);
    }

    public AppAlert(AlertType alertType, String title, String contentTitle, String description, AppAlertInterface appAlertInterface) {
        super(alertType);
        customAlert(title, contentTitle, description);
        Optional<ButtonType> optional = this.showAndWait();
        if (optional.isPresent()) {
            if (optional.get() == apply) {
                appAlertInterface.applyButtonPress();
            } else if (optional.get() == cancel) {
                appAlertInterface.cancelButtonPress();
            } else {
                System.out.println(optional.get().getText());
            }
        }
    }

    private void customAlert(String title, String contentTitle, String description) {
        this.getButtonTypes().clear();
        this.getButtonTypes().addAll(apply, cancel);
        this.setHeaderText(contentTitle);
        this.setContentText(description);
        this.setTitle(title);
    }
}