package weightAppUI.mainForm;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class WeightMainFormController implements WeightMainFormInterface {

    private boolean measureStatus;
    private String measureUnits = "кг";
    private StringBuilder sb = new StringBuilder();

    @FXML
    Button button;
    @FXML
    Label weightLabel;

    //Default constructor
    public WeightMainFormController() {
    }

    @FXML
    public void initialize() {
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!checkMeasureStatus()) {
                startMeasuring();
            } else {
                finishMeasuring();
            }
        });
    }

    @Override
    public String measureWeight() {

        return null;
    }

    @Override
    public Boolean startMeasuring() {
        button.setText("ПРЕКРАТИТЬ");
        weightLabel.setText("555");
        measureStatus = true;
        return true;
    }

    @Override
    public void setMeasureUnits(String measureUnits) {
        this.measureUnits = measureUnits;
    }

    @Override
    public String getMeasureUnits() {
        return "кг";
    }

    @Override
    public Boolean checkMeasureStatus() {
        return measureStatus;
    }

    @Override
    public Boolean finishMeasuring() {
        weightLabel.setText(sb.append("10000").append(measureUnits).toString());
        sb.setLength(0);
        measureStatus = false;
        return true;
    }
}