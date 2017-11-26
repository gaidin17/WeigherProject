package app.weighAppUI.form.view;


import app.weighAppUI.form.controller.RegistrationController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import app.weighAppUI.alerts.AppAlertInterface;
import app.weighAppUI.base.BaseForm;
import app.weighAppUI.form.formInterface.RegistrationInterface;
import app.weighAppUI.form.viewModel.WeighingViewModel;

import static java.lang.Thread.sleep;

public class RegistrationView extends BaseForm implements RegistrationInterface, AppAlertInterface {

    @FXML
    TextField organizationName;
    @FXML
    TextField adress;
    @FXML
    TextField taxpayerIdNumber;
    @FXML
    TextField driverName;
    @FXML
    TextField truckNumber;
    @FXML
    Button next;

    private boolean isWeighingStart = false;
    private boolean isFinish = false;

    private AutoCompletionBinding<String> autoCompletionBinding;
    RegistrationController registrationController;

    public RegistrationView() {
    }

    String[] organizations;// = {"ООО Рога и Копыта", "МУП Яндекс", "ЕПРСТ У Васи", "ЗАО ... в продакшн", "ПАО 40 лет без урожая"};
    String[] adreses;// = {"пл. Ленина", "Московский пр-т", "ул. Есенина", "пер. Трудолюбия", "1-й Пролетарский тупик"};
    String[] taxpayerIdNumbers;// = {"112252358", "4532443", "435245", "4358443", "2187354"};
    String[] driverNames;//= {"Иванов", "Петров", "Сидоров", "Асламбеков", "Овуавашва"};
    String[] truckNumbers;// = {"м448мм69", "а124мм69", "м573ар69", "м843нм69", "м278вк69"};


    @FXML
    public void initialize() {
        next.setOnAction(event -> setRegistrationData());
        adress.textProperty().addListener((observable, oldValue, newValue) -> {
        });
    }


    @Override
    public void init(String[] adreses, String[] organizations, String[] taxpayerIdNumbers, String[] driverNames, String[] truckNumbers) {
        this.organizations = organizations;
        this.taxpayerIdNumbers = taxpayerIdNumbers;
        this.driverNames = driverNames;
        this.adreses = adreses;
        this.truckNumbers = truckNumbers;

        TextFields.bindAutoCompletion(organizationName, this.organizations);
        TextFields.bindAutoCompletion(taxpayerIdNumber, this.taxpayerIdNumbers);
        TextFields.bindAutoCompletion(driverName, this.driverNames);
        TextFields.bindAutoCompletion(truckNumber, this.truckNumbers);
        autoCompletionBinding = TextFields.bindAutoCompletion(adress, this.adreses);
        autoCompletionBinding.setVisibleRowCount(10);
    }

    @Override
    public void setRegistrationData() {
        System.out.println(1);
    }

    @Override
    public void registerNewApplicationData() {

    }


    @Override
    public void successResponse(WeighingViewModel weighingViewModel) {

    }

    @Override
    public void errorResponse(String error) {

    }

    // create new thread at start, e.g. at the end for Application.start() method

    void runInNewThread() {

        final int[] i = {0};
        new Thread(() -> {
            while (!isWeighingStart) {
                if (isFinish) {
                    return;
                }
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i[0]++;
                // load my data
                // once loaded
                // update UI using
                Platform.runLater(() -> {
                    // AppAlert appAlert = new AppAlert(INFORMATION, "Test information", "YESSS", (LaunchView) this);
                    //  appAlert.setHeaderText("TESTTTTT");
                    // appAlert.show();

                    truckNumber.setText(String.valueOf(i[0]));
                    // here goes my update on FX UI thread
                });
                // update is done let's look for more data
            }
        }).start();
    }

    @Override
    public void startProgressbar() {

    }

    @Override
    public void stopProgressbar() {

    }

    @Override
    public void applyButtonPress() {

    }

    @Override
    public void cancelButtonPress() {

    }

}