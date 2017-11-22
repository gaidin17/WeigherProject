package weighAppUI.mainForm;

public interface WeighMainFormInterface {

    String measureWeight();

    Boolean startMeasuring();

    void setMeasureUnits(String measureValue);

    String getMeasureUnits();

    Boolean checkMeasureStatus();

    Boolean finishMeasuring();
}