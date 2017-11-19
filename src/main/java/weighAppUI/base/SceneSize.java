package weighAppUI.base;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneSize {

    private Double width = 500d;
    private Double height = 500d;
    private Parent root;

    public SceneSize(Parent root, Double width, Double height) {
        if (width != null) {
            this.width = width;
        }
        if (height != null) {
            this.height = height;
        }
        this.root = root;
    }

    public Scene createNewScene() {
        return new Scene(root, width, height);
    }
}
