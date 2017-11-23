package weighAppUI.form.view;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import weighAppUI.alerts.AppAlertInterface;
import weighAppUI.base.BaseForm;
import weighAppUI.form.formInterface.RegistrationInterface;
import weighAppUI.form.viewModel.WeighingViewModel;

import java.io.IOException;

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


    String[] organizations = {"ООО Рога и Копыта", "МУП Яндекс", "ЕПРСТ У Васи", "ЗАО ... в продакшн", "ПАО 40 лет без урожая"};
    String[] adreses = {"пл. Ленина", "Московский пр-т", "ул. Есенина", "пер. Трудолюбия", "1-й Пролетарский тупик"};
    String[] taxpayerIdNumbers = {"112252358", "4532443", "435245", "4358443", "2187354"};
    String[] driverNames = {"Иванов", "Петров", "Сидоров", "Асламбеков", "Овуавашва"};
    String[] truckNumbers = {"м448мм69", "а124мм69", "м573ар69", "м843нм69", "м278вк69"};


    @FXML
    public void initialize() {
        //runInNewThread();
      /*  next.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
            isWeighingStart = true;

        });*/

        next.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    String fxmlFile = "/fxml/weighing.fxml";
                    FXMLLoader loader = new FXMLLoader();
                    root = loader.load(getClass().getResourceAsStream(fxmlFile));
                    Stage stage = new Stage();
                    stage.setTitle("My New Stage Title");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        int k = 1000;
        k = k * adreses.length;
        String[] newArray = new String[k];
        for (int i = 0; i < k; i++) {
            newArray[i] = adreses[(int) (Math.random() * adreses.length)];
        }

        TextFields.bindAutoCompletion(organizationName, organizations);
        TextFields.bindAutoCompletion(taxpayerIdNumber, taxpayerIdNumbers);
        TextFields.bindAutoCompletion(driverName, driverNames);
        TextFields.bindAutoCompletion(truckNumber, truckNumbers);
        autoCompletionBinding = TextFields.bindAutoCompletion(adress, newArray);
        autoCompletionBinding.setVisibleRowCount(10);
        adress.textProperty().addListener((observable, oldValue, newValue) -> {

        });
    }


    @Override
    public void setRegistrationData() {

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