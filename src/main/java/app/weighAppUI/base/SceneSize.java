package app.weighAppUI.base;

import javafx.scene.Parent;
import javafx.scene.Scene;

class SceneSize {

    private Double width = 1000d;
    private Double height = 1000d;
    private Parent root;

    SceneSize(Parent root, Double width, Double height) {
        if (width != null) {
            this.width = width;
        }
        if (height != null) {
            this.height = height;
        }
        this.root = root;
    }

    Scene createNewScene() {
        return new Scene(root, width, height);
    }
}
