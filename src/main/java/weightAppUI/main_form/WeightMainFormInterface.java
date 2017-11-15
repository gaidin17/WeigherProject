package weightAppUI.main_form;

public interface WeightMainFormInterface {

    String measureWeight();

    Boolean startMeasuring();

    void setMeasureUnits(String measureValue);

    String getMeasureUnits();

    Boolean checkMeasureStatus();

    Boolean finishMeasuring();
}