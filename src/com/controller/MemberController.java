package com.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

import com.model.MemberOut;
import com.util.AppQuery;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MemberController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	editButton.setDisable(true);
    	deleteButton.setDisable(true);
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
    
    private MemberOut member;
    
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
    public void mouseClicked(MouseEvent e) {
    	try {
        	editButton.setDisable(false);
        	deleteButton.setDisable(false);
        	member = tableView.getSelectionModel().getSelectedItem();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    
    @FXML
    public void handleUpdateButton(ActionEvent event) {
        if (member != null) {
            try {          
                // Load the FXML for the new window
            	FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/view/UpdateForm.fxml"));
            	Parent root = loader.load();
            	
                // Create a new stage (window) for the form
                Stage updateStage = new Stage();
                updateStage.setTitle("update Member");
                updateStage.setScene(new Scene(root));
                
            	
                updateStage.initModality(Modality.APPLICATION_MODAL); // Modal window, blocks interaction with the parent window
                updateStage.setTitle("Update Member");

                // Pass the member data to the new window (controller of UpdateForm)
                UpdateFormController updateController = loader.getController();
                updateController.setMemberData(member); 

                // Set the scene and show the new window
                updateStage.show();
            } catch (IOException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Failed to open update window");
                alert.setContentText("Error details: " + e.getMessage());
                alert.showAndWait();
                e.printStackTrace();  // Ensure you also print the full stack trace
            }
        } else {
            // If no member is selected
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Member Selected");
            alert.setHeaderText("Please select a member to update.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void openForm(ActionEvent event) {
        try {
            // Load the FXML file for the MemberForm
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/view/MemberForm.fxml"));
            Parent root = loader.load();

            // Get the controller for MemberForm and set the reference of this MemberController instance
            MemberFormController memberFormController = loader.getController();
            memberFormController.setMemberController(this); // Pass the current MemberController instance
            
            // Create a new stage (window) for the form
            Stage stage = new Stage();
            stage.setTitle("Add New Member");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace if there's an error
        }
    }
    
    
    
    @FXML
    public void handleDeleteMember(ActionEvent event) {
        try {
            // Get the selected member
            member = tableView.getSelectionModel().getSelectedItem();
            
            // If no member is selected, show a warning
            if (member == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Member Selected");
                alert.setHeaderText("Please select a member to delete.");
                alert.showAndWait();
                return; // Exit if no member is selected
            }
            
            // Show a confirmation dialog before proceeding with the deletion
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmationAlert.setTitle("Confirm Deletion");
            confirmationAlert.setHeaderText("Are you sure you want to delete this member?");
            confirmationAlert.setContentText("This action cannot be undone.");
            
            // Show the confirmation dialog and wait for the user's response
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            
            // If the user confirms, proceed with the deletion
            if (result.isPresent() && result.get() == ButtonType.OK) {
                AppQuery appQuery = new AppQuery();
                appQuery.deleteMember(member.getId());  // Delete the member from the database
                refreshTable();  // Refresh the table to reflect the deletion
                System.out.println("Deleted member: " + member);
            } else {
                // If the user cancels, just show a message
                System.out.println("Deletion canceled.");
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the stack trace if an exception occurs
        }
    }



    	
    public void refreshTable() {
        showMembers();
    }
}
