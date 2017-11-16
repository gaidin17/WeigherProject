package weightAppUI.registrationForm;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.textfield.TextFields;

import static java.lang.Thread.sleep;


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


    String[] organizations = {"ООО Рога и Копыта", "МУП Яндекс", "ЕПРСТ У Васи", "ЗАО ... в продакшн", "ПАО 40 лет без урожая"};
    String[] adreses = {"пл. Ленина", "Московский пр-т", "ул. Есенина", "пер. Трудолюбия", "1-й Пролетарский тупик"};
    String[] taxpayerIdNumbers = {"112252358", "4532443", "435245", "4358443", "2187354"};
    String[] driverNames = {"Иванов", "Петров", "Сидоров", "Асламбеков", "Овуавашва"};
    String[] truckNumbers = {"м448мм69", "а124мм69", "м573ар69", "м843нм69", "м278вк69"};

    @FXML
    public void initialize() {
        next.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {

        });

        int k = 1000;
        k = k * adreses.length;
        String[] newArray = new String[k];
        for (int i = 0; i < k; i++) {
            newArray[i] = adreses[(int) (Math.random() * adreses.length)];
        }

        TextFields.bindAutoCompletion(organizationName, organizations);
        //adressComplete = TextFields.bindAutoCompletion(adress, newArray);
        TextFields.bindAutoCompletion(taxpayerIdNumber, taxpayerIdNumbers);
        TextFields.bindAutoCompletion(driverName, driverNames);
        TextFields.bindAutoCompletion(truckNumber, truckNumbers);
        //adressComplete.setUserInput(Arrays.toString(organizations));

        TextFields.bindAutoCompletion(adress,"text to suggest", "another text to suggest");
    }

}
