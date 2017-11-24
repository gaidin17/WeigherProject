package app.weighAppUI.form.view;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import app.weighAppUI.alerts.AppAlert;
import app.weighAppUI.alerts.AppAlertInterface;
import app.weighAppUI.base.BaseForm;
import app.weighAppUI.base.UIProgressbarInterface;
import app.weighAppUI.form.formInterface.LaunchViewInterface;


public class LaunchView extends BaseForm implements LaunchViewInterface, UIProgressbarInterface, AppAlertInterface {

    @FXML
    public Button application;
    @FXML
    public Button report;
    @FXML
    public AnchorPane progress;

    private boolean isApplicationButtonPress = false;
    private boolean isReportButtonPress = false;

    @FXML
    public void initialize() {
        initButtons();
        stopProgressbar();
    }

    private void initButtons() {
        application.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> applicationButtonPress());
        report.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> reportButtonPress());
    }

    @Override
    public void startProgressbar() {
        progress.setVisible(true);
    }

    @Override
    public void stopProgressbar() {
        progress.setVisible(false);
        setDefaultValue();
    }

    @Override
    public void applicationButtonPress() {
        isApplicationButtonPress = true;
        startProgressbar();
        new AppAlert(Alert.AlertType.INFORMATION, "ЗАЯВКА", "Новая заявка", "Вы действительно хотите создать новую заявку?", this);
    }

    @Override
    public void reportButtonPress() {
        isReportButtonPress = true;
        startProgressbar();
        new AppAlert(Alert.AlertType.INFORMATION, "ОТЧЕТ", "Новый отчет", "Создание отчета в данный момент невозможно", this);
    }

    @Override
    public void applyButtonPress() {
        if (isApplicationButtonPress) {
            openNewForm(application, "/fxml/registration.fxml", "", null, null, false);
        }
        if (isReportButtonPress) {
            System.out.println("report button was pressed"); //TODO add realization if report creation enable
        }
        stopProgressbar();
    }

    @Override
    public void cancelButtonPress() {
        stopProgressbar();
    }

    private void setDefaultValue(){
        isReportButtonPress = false;
        isApplicationButtonPress = false;
    }
}
