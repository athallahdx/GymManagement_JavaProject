package com.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.model.MemberIn;
import com.model.MemberOut;
import com.util.AppQuery;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class UpdateFormController implements Initializable {

    @FXML private TextField fullNameField;
    @FXML private RadioButton maleSexRadioButton;
    @FXML private RadioButton femaleSexRadioButton;
    @FXML private TextField phoneNumberField;
    @FXML private DatePicker birthDatePicker;
    @FXML private RadioButton yesStudentRadioButton;
    @FXML private RadioButton noStudentRadioButton;
    @FXML private DatePicker registeredDatePicker;
    @FXML private TextField registeredTimeField;
    @FXML private DatePicker lastPaymentDatePicker;
    @FXML private TextField lastPaymentTimeField;
    @FXML private DatePicker membershipDueDatePicker;
    @FXML private TextField membershipDueTimeField;
    @FXML private Button btnUpdateMember;
    
    // ToggleGroups for grouping radio buttons
    private ToggleGroup sexToggleGroup;
    private ToggleGroup studentToggleGroup;

    private MemberOut member;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ToggleGroups for Sex and Student status
        sexToggleGroup = new ToggleGroup();
        maleSexRadioButton.setToggleGroup(sexToggleGroup);
        femaleSexRadioButton.setToggleGroup(sexToggleGroup);

        studentToggleGroup = new ToggleGroup();
        yesStudentRadioButton.setToggleGroup(studentToggleGroup);
        noStudentRadioButton.setToggleGroup(studentToggleGroup);
        
        phoneNumberField.setText("");
    }
    
    @FXML
    public void handleUpdateMember(ActionEvent event) {
        // Get values from UI elements
        String fullName = fullNameField.getText();
        boolean isStudent = yesStudentRadioButton.isSelected();
        LocalDate birthdate = birthDatePicker.getValue();
        String phoneNumber = phoneNumberField.getText();
        
        // Retrieve registered date and time
        LocalDate registeredDate = registeredDatePicker.getValue();
        String registeredTime = registeredTimeField.getText();  // Time input in HH:mm format
        
        // Retrieve last membership payment date and time
        LocalDate lastPaymentDate = lastPaymentDatePicker.getValue();
        String lastPaymentTime = lastPaymentTimeField.getText();  // Time input in HH:mm format
        
        // Retrieve membership due date and time
        LocalDate membershipDueDate = membershipDueDatePicker.getValue();
        String membershipDueTime = membershipDueTimeField.getText();  // Time input in HH:mm format
        
        // Convert Date and Time into LocalDateTime
        LocalDateTime registeredDateTime = convertToLocalDateTime(registeredDate, registeredTime);
        LocalDateTime lastPaymentDateTime = convertToLocalDateTime(lastPaymentDate, lastPaymentTime);
        LocalDateTime currentMembershipDue = convertToLocalDateTime(membershipDueDate, membershipDueTime);
        
        // Determine the selected sex
        String sex = maleSexRadioButton.isSelected() ? "Male" : "Female";

        
        System.out.println("Member :"+  member.toString());
        // Create the member object
        MemberIn memberIn = new MemberIn(member.getId(), fullName, sex, birthdate, phoneNumber, isStudent, registeredDateTime, lastPaymentDateTime, currentMembershipDue);

        // Add the member to the database
        AppQuery appQuery = new AppQuery();
        appQuery.updateMember(memberIn);

        
        // Close the form window after saving
        ((Stage) btnUpdateMember.getScene().getWindow()).close();
    }

    // Helper method to convert LocalDate and time string into LocalDateTime
    public static LocalDateTime convertToLocalDateTime(LocalDate date, String time) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(time, timeFormatter);
        return LocalDateTime.of(date, localTime);
    }



    public void setMemberData(MemberOut member) {
        this.member = member;
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Set the values from the member object into the corresponding fields
        if (member != null) {
            fullNameField.setText(member.getFullName());
            
            // Set sex (Male or Female)
            if (member.getSex().equalsIgnoreCase("Male")) {
                maleSexRadioButton.setSelected(true);
            } else {
                femaleSexRadioButton.setSelected(true);
            }

            // Set phone number
            phoneNumberField.setText(member.getPhoneNumber());

            // Set birth date
            birthDatePicker.setValue(member.getBirthdate()); // assuming birthDate is a LocalDate

            // Set student status (Yes or No)
            if (member.isStudent()) {
                yesStudentRadioButton.setSelected(true);
            } else {
                noStudentRadioButton.setSelected(true);
            }

            // Set the registered date and time
            if (member.getRegisteredDate() != null) {
                registeredDatePicker.setValue(member.getRegisteredDate().toLocalDate()); // Set date part
                registeredTimeField.setText(member.getRegisteredDate().toLocalTime().format(timeFormatter)); // Set time part (HH:mm)
            }

            // Set the last membership payment date and time
            if (member.getLastMembershipPaymentDate() != null) {
                lastPaymentDatePicker.setValue(member.getLastMembershipPaymentDate().toLocalDate()); // Set date part
                lastPaymentTimeField.setText(member.getLastMembershipPaymentDate().toLocalTime().format(timeFormatter)); // Set time part (HH:mm)
            }

            // Set the membership due date and time
            if (member.getCurrentMembershipDue() != null) {
                membershipDueDatePicker.setValue(member.getCurrentMembershipDue().toLocalDate()); // Set date part
                membershipDueTimeField.setText(member.getCurrentMembershipDue().toLocalTime().format(timeFormatter)); // Set time part (HH:mm)
            }
        }
    }

}
