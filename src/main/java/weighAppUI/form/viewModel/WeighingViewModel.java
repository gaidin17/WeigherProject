package weighAppUI.form.viewModel;

public class WeighingViewModel {

    private String weightUnits;
    private String vehicleNumber;
    private String currentWeight;
    private boolean isWeightFix;
    private boolean isSecondWeighting;

    public WeighingViewModel() {
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public boolean isWeightFix() {
        return isWeightFix;
    }

    public void setWeightFix(boolean weightFix) {
        isWeightFix = weightFix;
    }

    public boolean isSecondWeighting() {
        return isSecondWeighting;
    }

    public void setSecondWeighting(boolean secondWeighting) {
        isSecondWeighting = secondWeighting;
    }
}