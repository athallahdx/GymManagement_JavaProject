package com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MemberFormController extends Initializable{
	
	String fullname;
	String SexRadioButtonValue;
	
	@override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	@FXML
	public TextField fullnamefullNameField;
	@FXML
	public RadioButton maleSexRadioButton, femaleSexRadioButton;
	@FXML
	public TextField phoneNumberField;
	@FXML
	public DatePicker birthDatePicker;
	@FXML
	public RadioButton yesStudentRadioButton, noStudentRadioButton;
	@FXML
	public Button btnCreateMember;
	
	public void getSex(ActionEvent event) {
        if(maleSexRadioButton.isSelected()) {
            SexRadioButtonValue = maleSexRadioButton.getText();
		} else if (femaleSexRadioButton.isSelected()) {
			SexRadioButtonValue = femaleSexRadioButton.getText();
		}
        
	}
	
	private void addMember() {
		com.model.Member member = new com.model.Member(fullname, sex, phoneNumber, birthDatePicker, isStudent);
	}
	
	
}
