package app.weighAppUI.form.controller;

import app.domain.Driver;
import app.domain.Organization;
import app.domain.Truck;
import app.service.DriverService;
import app.service.OrganizationService;
import app.service.TruckService;
import app.weighAppUI.form.viewModel.WeighingViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.weighAppUI.form.formInterface.RegistrationInterface;
import app.weighAppUI.form.view.RegistrationView;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegistrationController  implements  RegistrationInterface{

    @Autowired
    private
    OrganizationService organizationService;

    @Autowired
    private
    TruckService truckService;

    @Autowired
    private
    DriverService driverService;

    private List<Organization> organizationsDB = new ArrayList<>();
    private List<Truck> trucksDB = new ArrayList<>();
    private List<Driver> driversDB = new ArrayList<>();

    public RegistrationInterface getRegistrationInterface() {
        return registrationInterface;
    }

    public void setRegistrationInterface(RegistrationInterface registrationInterface) {
        this.registrationInterface = registrationInterface;
    }

    private RegistrationInterface registrationInterface = new RegistrationView();

    private String[] organizations;// = {"ООО Рога и Копыта", "МУП Яндекс", "ЕПРСТ У Васи", "ЗАО ... в продакшн", "ПАО 40 лет без урожая"};
    private String[] adreses;// = {"пл. Ленина", "Московский пр-т", "ул. Есенина", "пер. Трудолюбия", "1-й Пролетарский тупик"};
    private String[] taxpayerIdNumbers; // = {"112252358", "4532443", "435245", "4358443", "2187354"};
    private String[] driverNames; // = {"Иванов", "Петров", "Сидоров", "Асламбеков", "Овуавашва"};
    private String[] truckNumbers; // = {"м448мм69", "а124мм69", "м573ар69", "м843нм69", "м278вк69"};


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

        ArrayList<String> tracksNum = new ArrayList<>();
        trucksDB = truckService.getAll();
        for (Truck truck : trucksDB) {
            tracksNum.add(truck.getNumber());
        }

        ArrayList<String> driversNames = new ArrayList<>();
        driversDB = driverService.getAll();
        for (Driver driver : driversDB) {
            driversNames.add(driver.getName());
        }

        int size = organizationsDB.size();
        organizations = new String[size];
        adreses = new String[size];
        taxpayerIdNumbers = new String[size];
        driverNames = new String[driversNames.size()];
        truckNumbers = new String[tracksNum.size()];

        driversNames.toArray(driverNames);
        tracksNum.toArray(truckNumbers);
        names.toArray(organizations);
        address.toArray(adreses);
        taxpayerId.toArray(taxpayerIdNumbers);

    }

    public void initial() {
        registrationInterface.init(adreses,
                organizations,
                taxpayerIdNumbers,
                driverNames,
                truckNumbers);
    }

    @Override
    public void init(String[] adreses, String[] organizations, String[] taxpayerIdNumbers, String[] driverNames, String[] truckNumbers) {

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
}