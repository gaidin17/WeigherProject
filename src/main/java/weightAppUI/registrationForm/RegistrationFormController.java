package weightAppUI.registrationForm;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import weightAppUI.alerts.AppAlert;

import static java.lang.Thread.sleep;
import static javafx.scene.control.Alert.AlertType.INFORMATION;


public class RegistrationFormController implements RegistrationFormInterface {

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

    boolean isB = false;

    AutoCompletionBinding<String> autoCompletionBinding;


    String[] organizations = {"ООО Рога и Копыта", "МУП Яндекс", "ЕПРСТ У Васи", "ЗАО ... в продакшн", "ПАО 40 лет без урожая"};
    String[] adreses = {"пл. Ленина", "Московский пр-т", "ул. Есенина", "пер. Трудолюбия", "1-й Пролетарский тупик"};
    String[] taxpayerIdNumbers = {"112252358", "4532443", "435245", "4358443", "2187354"};
    String[] driverNames = {"Иванов", "Петров", "Сидоров", "Асламбеков", "Овуавашва"};
    String[] truckNumbers = {"м448мм69", "а124мм69", "м573ар69", "м843нм69", "м278вк69"};

    @FXML
    public void initialize() {
        runInNewThread();
        next.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
            isB = true;
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
        adress.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });
    }


    @Override
    public void openWeightingForm() {

    }

    @Override
    public void setRegistrationData() {

    }

    @Override
    public void saveNewApplicationData() {

    }

    // create new thread at start, e.g. at the end for Application.start() method

    void runInNewThread() {

        final int[] i = {0};
        new Thread(() -> {
            while (!isB) {
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
                    AppAlert appAlert = new AppAlert(INFORMATION, "Test information", "YESSS");
                    appAlert.setHeaderText("TESTTTTT");
                    appAlert.show();

                    truckNumber.setText(String.valueOf(i[0]));
                    // here goes my update on FX UI thread
                });
                // update is done let's look for more data
            }
        }).start();
    }
}