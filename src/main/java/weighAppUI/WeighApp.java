package weighAppUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WeighApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fxmlFile = "/fxml/launch_form.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent rootNode = loader.load(getClass().getResourceAsStream(fxmlFile));
        primaryStage.setTitle("СТАРТОВЫЙ ЭКРАН");
        primaryStage.setScene(new Scene(rootNode));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}