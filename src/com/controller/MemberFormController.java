package com.controller;

import com.model.MemberIn;
import com.model.MemberOut;
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

public class MemberFormController implements Initializable {

    // FXML elements
    @FXML
    public TextField fullNameField;
    @FXML
    public RadioButton maleSexRadioButton;
    @FXML
    public RadioButton femaleSexRadioButton;
    @FXML
    public DatePicker birthDatePicker;
    @FXML
    public RadioButton yesStudentRadioButton;
    @FXML
    public RadioButton noStudentRadioButton;
    @FXML
    public Button btnCreateMember;

    // ToggleGroups for grouping radio buttons
    private ToggleGroup sexToggleGroup;
    private ToggleGroup studentToggleGroup;

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
        LocalDateTime registeredDate = LocalDateTime.now();
        LocalDateTime lastMembershipPaymentDate = LocalDateTime.now();
        LocalDateTime currentMembershipDue = lastMembershipPaymentDate.plusDays(30);
        String membershipStatus = "Active";

        // Determine the selected sex
        String sex = "";
        if (maleSexRadioButton.isSelected()) {
            sex = "Male";
        } else if (femaleSexRadioButton.isSelected()) {
            sex = "Female";
        }

        // Create the member object
        MemberIn member = new MemberIn(null, fullName, sex, birthdate, isStudent, registeredDate, lastMembershipPaymentDate, currentMembershipDue, membershipStatus);

        // Add the member to the database
        AppQuery appQuery = new AppQuery();
        appQuery.addMember(member);
    }
}
