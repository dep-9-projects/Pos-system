package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;

public class FirstTimeLoginFormController {
    public JFXTextField txtUsername;
    public JFXTextField txtPassword;
    public JFXTextField txtPassword1;
    public AnchorPane pneFirstTimeLoginContainer;
    public JFXButton btnEnterAsAdmin;

    public void btnEnterAsAdminOnAction(ActionEvent actionEvent) {

        if(txtUsername.getText() == "system-user" && txtPassword.getText() == "1234");


    }
}
