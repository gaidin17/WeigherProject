package weighAppUI;

import app.Main;
import app.utils.initialization.InitialisationServise;
import app.utils.port.ComPortManager;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weighAppUI.base.BaseForm;
import weighAppUI.form.controller.LaunchController;

public class WeighApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        InitialisationServise initialisationServise = context.getBean(InitialisationServise.class);
        ComPortManager comPortManager = context.getBean(ComPortManager.class);
        comPortManager.startReadData();
        initialisationServise.init();
        LaunchController launchController = new LaunchController();
        ((BaseForm) launchController.getLaunchViewInterface()).openNewForm(null, "/fxml/launch.fxml", "Start screen", null, null, false);
    }
}