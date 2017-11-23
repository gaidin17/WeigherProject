package weighAppUI.form.formInterface;


import weighAppUI.form.viewModel.WeighingViewModel;

public interface RegistrationInterface {

    void setRegistrationData();

    void registerNewApplicationData();

    void successResponse(WeighingViewModel weighingViewModel);

    void errorResponse(String error);
}