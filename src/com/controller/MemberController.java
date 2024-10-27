package com.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.model.MemberForm;
import com.model.MemberOut;
import com.util.AppQuery;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MemberController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showMembers();
    }
    
    @FXML
    private Button addButton;
    
    @FXML
    private Button editButton;
    
    @FXML
    private Button deleteButton;
    
    @FXML
    private TableColumn<MemberOut, Integer> colId;
    
    @FXML
    private TableColumn<MemberOut, String> colName;
    
    @FXML
    private TableColumn<MemberOut, String> colSex;
    
    @FXML
    private TableColumn<MemberOut, LocalDate> colBirthDate;
    
    @FXML
    private TableColumn<MemberOut, String> colPhoneNumber;
    
    @FXML
    private TableColumn<MemberOut, Boolean> colIsStudent;
    
    @FXML
    private TableColumn<MemberOut, LocalDateTime> colRegisteredDate;
    
    @FXML
    private TableColumn<MemberOut, LocalDateTime> colLastMembershipPaymentDate;
    
    @FXML
    private TableColumn<MemberOut, LocalDateTime> colCurrentMembershipDue;
    
    @FXML
    private TableColumn<MemberOut, String> colMembershipStatus;
    
    @FXML
    private TableView<MemberOut> tableView;
    
    @FXML
    private void showMembers() {
        AppQuery appQuery = new AppQuery();
        ObservableList<MemberOut> memberList = appQuery.getMemberList();
        
        colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        colName.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        colSex.setCellValueFactory(cellData -> cellData.getValue().sexProperty());
        colBirthDate.setCellValueFactory(cellData -> cellData.getValue().birthdateProperty());
        colPhoneNumber.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        colIsStudent.setCellValueFactory(cellData -> cellData.getValue().isStudentProperty().asObject());
        colRegisteredDate.setCellValueFactory(cellData -> cellData.getValue().registeredDateProperty());
        colLastMembershipPaymentDate.setCellValueFactory(cellData -> cellData.getValue().lastMembershipPaymentDateProperty());
        colCurrentMembershipDue.setCellValueFactory(cellData -> cellData.getValue().currentMembershipDueProperty());
        colMembershipStatus.setCellValueFactory(cellData -> cellData.getValue().membershipStatusProperty());
        
        tableView.setItems(memberList);
    }    
    
    @FXML
    private void openForm(ActionEvent event) {
        try {
            // Load the FXML file for the MemberForm
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/view/MemberForm.fxml"));
            Parent root = loader.load();

            // Create a new stage (window) for the form
            Stage stage = new Stage();
            stage.setTitle("Add New Member");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace if there's an error
        }
    }

}
