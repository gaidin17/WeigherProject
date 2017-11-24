package app.weighAppUI.form.formInterface;


import app.weighAppUI.form.viewModel.WeighingViewModel;

public interface RegistrationInterface {

    void init(String[] adreses, String[] organizations, String[] taxpayerIdNumbers, String[] driverNames, String[] truckNumbers);

    void setRegistrationData();

    void registerNewApplicationData();

    void successResponse(WeighingViewModel weighingViewModel);

    void errorResponse(String error);
}