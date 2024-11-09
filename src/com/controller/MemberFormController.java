package com.controller;

import com.model.MemberIn;
import com.util.AppQuery;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MemberFormController implements Initializable {

    @FXML
    private TextField fullNameField;
    
    @FXML
    private TextField phoneNumberField;
    
    @FXML
    private RadioButton maleSexRadioButton;
    @FXML
    private RadioButton femaleSexRadioButton;
    @FXML
    private DatePicker birthDatePicker;
    @FXML
    private RadioButton yesStudentRadioButton;
    @FXML
    private RadioButton noStudentRadioButton;
    @FXML
    private Button btnCreateMember;

    // ToggleGroups for grouping radio buttons
    private ToggleGroup sexToggleGroup;
    private ToggleGroup studentToggleGroup;

    // Reference to the MemberController
    private MemberController memberController;

    public void setMemberController(MemberController memberController) {
        this.memberController = memberController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ToggleGroups for Sex and Student status
        sexToggleGroup = new ToggleGroup();
        maleSexRadioButton.setToggleGroup(sexToggleGroup);
        femaleSexRadioButton.setToggleGroup(sexToggleGroup);

        studentToggleGroup = new ToggleGroup();
        yesStudentRadioButton.setToggleGroup(studentToggleGroup);
        noStudentRadioButton.setToggleGroup(studentToggleGroup);
    }

    @FXML
    public void handleCreateMember(ActionEvent event) {
        // Get values from UI elements
        String fullName = fullNameField.getText();
        boolean isStudent = yesStudentRadioButton.isSelected();
        LocalDate birthdate = birthDatePicker.getValue();
        String phoneNumber = phoneNumberField.getText();
        LocalDateTime registeredDate = LocalDateTime.now();
        LocalDateTime lastMembershipPaymentDate = LocalDateTime.now();
        LocalDateTime currentMembershipDue = lastMembershipPaymentDate.plusDays(31);
        String membershipStatus = "Active";

        // Determine the selected sex
        String sex = maleSexRadioButton.isSelected() ? "Male" : "Female";

        // Create the member object
        MemberIn member = new MemberIn(null, fullName, sex, birthdate, phoneNumber, isStudent, registeredDate, lastMembershipPaymentDate, currentMembershipDue, membershipStatus);

        // Add the member to the database
        AppQuery appQuery = new AppQuery();
        appQuery.addMember(member);

        // Refresh the table in MemberController
        if (memberController != null) {
            memberController.refreshTable();
        }
        
        // Close the form window after saving
        ((Stage) btnCreateMember.getScene().getWindow()).close();
    }
}
