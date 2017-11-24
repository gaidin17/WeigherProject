package app.weighAppUI.form.controller;

import app.domain.Organization;
import app.service.DriverService;
import app.service.OrganizationService;
import app.service.TruckService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.weighAppUI.form.formInterface.RegistrationInterface;
import app.weighAppUI.form.view.RegistrationView;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RegistrationController {

    @Autowired
    OrganizationService organizationService;

    @Autowired
    TruckService truckService;

    @Autowired
    DriverService driverService;

    List<Organization> organizationsDB = new ArrayList<>();

    public RegistrationInterface getRegistrationInterface() {
        return registrationInterface;
    }

    public void setRegistrationInterface(RegistrationInterface registrationInterface) {
        this.registrationInterface = registrationInterface;
    }
    @Autowired
    RegistrationInterface registrationInterface;

    String[] organizations;// = {"ООО Рога и Копыта", "МУП Яндекс", "ЕПРСТ У Васи", "ЗАО ... в продакшн", "ПАО 40 лет без урожая"};
    String[] adreses;// = {"пл. Ленина", "Московский пр-т", "ул. Есенина", "пер. Трудолюбия", "1-й Пролетарский тупик"};
    String[] taxpayerIdNumbers; // = {"112252358", "4532443", "435245", "4358443", "2187354"};
    String[] driverNames; // = {"Иванов", "Петров", "Сидоров", "Асламбеков", "Овуавашва"};
    String[] truckNumbers; // = {"м448мм69", "а124мм69", "м573ар69", "м843нм69", "м278вк69"};


    public void init() {
        organizationsDB = organizationService.getAll();
        ArrayList<String> taxpayerId = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> address = new ArrayList<>();
        for (Organization organization : organizationsDB) {
            taxpayerId.add(organization.getInn());
            names.add(organization.getName());
            address.add(organization.getAddress());
        }

        int size = organizationsDB.size();
        organizations = new String[size];
        adreses = new String[size];
        taxpayerIdNumbers = new String[size];
        names.toArray(organizations);
        address.toArray(adreses);
        taxpayerId.toArray(taxpayerIdNumbers);

        Parent root;
        try {
            String fxmlFile = "/fxml/registration.fxml";
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResourceAsStream(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
            // Hide this current window (if this is what you want)
            //((Node) (event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initial() {
        registrationInterface.init(adreses, organizations, taxpayerIdNumbers, driverNames, truckNumbers);
    }
}
