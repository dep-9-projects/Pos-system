package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import util.Customers;

public class ManageCustomersController {

    public Button btnAdd;
    public Button btnUpdate;
    public Button btnRemove;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtContactNum;
    public TableView<Customers> tblCustomers;

    public void initialize() {
        txtContactNum.requestFocus();
        txtName.setDisable(true);
        txtAddress.setDisable(true);

        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));


    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        if (txtName.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR, "Name Cant Be Empty").showAndWait();
            txtName.requestFocus();
            txtName.selectAll();
            return;

        } else if (!isName(txtName.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invaild Name").showAndWait();
            txtName.requestFocus();
            txtName.selectAll();
            return;
        } else if (txtContactNum.getText().isBlank()) {
            new Alert(Alert.AlertType.ERROR, "NIC Cant Be Empty").showAndWait();
            txtContactNum.requestFocus();
            txtContactNum.selectAll();
            return;

        } else if (!isContactNumber(txtContactNum.getText())) {
            new Alert(Alert.AlertType.ERROR, "Invaild Number.Use 07*-*******").showAndWait();
            txtContactNum.requestFocus();
            txtContactNum.selectAll();
            return;

        }
        tblCustomers.getItems().add(new Customers(txtContactNum.getText(),txtName.getText(), txtAddress.getText()));
    }

    public void btnRemoveOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void txtContactNumOnAction(ActionEvent actionEvent) {
        txtName.setDisable(false);
        txtAddress.setDisable(false);
    }

    public void txtContactNumOnKey(KeyEvent keyEvent) {
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        if (txtContactNum.getText().isEmpty()) {
            txtName.setDisable(true);
            txtAddress.setDisable(true);
        }
    }

    private boolean isContactNumber(String input) {
        if (!(input.length() == 11 && input.charAt(3) == '-')) return false;
        return input.substring(0, 3).matches("\\d+") && input.substring(4, 11).matches("\\d+");
    }

    private boolean isName(String input) {
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (!(Character.isLetter(aChar) || aChar == ' ')) return false;
        }
        return true;
    }
}