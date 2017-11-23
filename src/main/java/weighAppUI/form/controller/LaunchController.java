package weighAppUI.form.controller;

import weighAppUI.form.formInterface.LaunchViewInterface;
import weighAppUI.form.view.LaunchView;
import weighAppUI.form.viewModel.LaunchViewModel;

public class LaunchController {

    private LaunchViewInterface launchViewInterface = new LaunchView();
    private LaunchViewModel launchViewModel = new LaunchViewModel();

    public LaunchViewInterface getLaunchViewInterface() {
        return launchViewInterface;
    }

    public void setLaunchViewInterface(LaunchViewInterface launchViewInterface) {
        this.launchViewInterface = launchViewInterface;
    }

    public LaunchViewModel getLaunchViewModel() {
        return launchViewModel;
    }

    public void setLaunchViewModel(LaunchViewModel launchViewModel) {
        this.launchViewModel = launchViewModel;
    }

    public LaunchController() {
    }
}