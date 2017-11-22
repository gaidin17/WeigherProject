package weighAppUI.registrationForm;

import app.domain.Weighing;

public interface RegistrationFormInterface {

    void setRegistrationData();

    void sendNewApplicationDataToDB();

    void successResponceFromDB(Weighing weighing);

    void errorResponceFromDB(String error);
}