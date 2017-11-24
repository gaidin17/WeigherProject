package app.weighAppUI.form.controller;

import app.weighAppUI.form.formInterface.LaunchViewInterface;
import app.weighAppUI.form.view.LaunchView;
import app.weighAppUI.form.viewModel.LaunchViewModel;

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