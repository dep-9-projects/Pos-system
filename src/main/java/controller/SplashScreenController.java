package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashScreenController {
    public Label lblLoading;
    public Rectangle rctContainer;
    public Rectangle rctLoading;

    public void initialize() {
        Timeline timeline = new Timeline();
        var keyFrame1 = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Connecting UI Components");
                rctLoading.setWidth(rctLoading.getWidth() + 20);
            }
        });
        var keyFrame2 = new KeyFrame(Duration.millis(750), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Connecting Database....");
                rctLoading.setWidth(rctLoading.getWidth() + 60);
            }
        });
        var keyFrame3 = new KeyFrame(Duration.millis(2000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("Loading All ");
                rctLoading.setWidth(rctLoading.getWidth() + 50);
            }
        });
        var keyFrame4 = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoading.setText("INITILIAZING.....");
                rctLoading.setWidth(rctLoading.getWidth() + 60);
            }
        });

        var keyFrame5 = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                rctLoading.setWidth(rctContainer.getWidth());
                URL resource = this.getClass().getResource("/view/MainForm.fxml");
                Parent container = null;
                try {
                    container = FXMLLoader.load(resource);
                    Scene scene = new Scene(container);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    scene.setFill(Color.TRANSPARENT);
                    stage.show();
                    stage.centerOnScreen();
                    lblLoading.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        timeline.getKeyFrames().addAll(keyFrame1, keyFrame2, keyFrame3, keyFrame4,keyFrame5);
        timeline.playFromStart();
    }
}
