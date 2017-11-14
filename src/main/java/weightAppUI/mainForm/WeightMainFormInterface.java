package weightAppUI.mainForm;

public interface WeightMainFormInterface {
    Double measureWeight();

    Boolean startMeasuring();

    void setMeasureUnits(String measureValue);

    String getMeasureUnits();

    Boolean checkMeasureStatus();

    Boolean finishMeasuring();
}