package com.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GymDashboard extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/com/view/DashboardView.fxml"));
    		Scene scene = new Scene(root);
    		
    		String css = getClass().getResource("/com/view/DashboardView.css").toExternalForm();
            scene.getStylesheets().add(css);
    		
    		stage.setScene(scene);
    		stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
