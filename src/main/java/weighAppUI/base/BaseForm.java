package weighAppUI.base;

import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseForm implements UIProgressbarInterface {

    public void openNewForm(Node node, String fxmlFile, String title, Double width, Double height, Boolean isLastFormClose) {
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResourceAsStream(fxmlFile));
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new SceneSize(root, width, height).createNewScene());
            stage.show();
            if (isLastFormClose) {
                (node.getScene().getWindow()).hide();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}