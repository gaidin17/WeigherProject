package weighAppUI.form.formInterface;

public interface WeighingInterface {

    String measureWeight();

    Boolean startMeasuring();

    void setMeasureUnits(String measureValue);

    String getMeasureUnits();

    Boolean checkMeasureStatus();

    Boolean finishMeasuring();
}