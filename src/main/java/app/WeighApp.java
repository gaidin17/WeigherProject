package app;

import app.utils.initialization.InitialisationServise;
import app.utils.port.ComPortManager;
import app.weighAppUI.base.BaseForm;
import app.weighAppUI.form.controller.RegistrationController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class WeighApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(WeighApp.class);
        InitialisationServise initialisationServise = context.getBean(InitialisationServise.class);
        initialisationServise.init();
        ComPortManager comPortManager = context.getBean(ComPortManager.class);
        RegistrationController registrationController = context.getBean(RegistrationController.class);
        registrationController.init();
        comPortManager.startReadData();
        ((BaseForm) registrationController.getRegistrationInterface()).openNewForm(null,
                "/fxml/registration.fxml",
                "Registration screen",
                null,
                null,
                false);
        registrationController.initial();
    }
}