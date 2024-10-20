package com.model;

import com.util.DatabaseConnection; // Import the DatabaseConnection class
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemberForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseConnection db = new DatabaseConnection();
        db.getDBConn();  // Connect to the database
        System.out.println("Connection status: " + db.getCon());  // Print connection status

        try {
            // Correct the path for the FXML file
        	Parent root = FXMLLoader.load(getClass().getResource("/com/view/MemberForm.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Gym Member Management");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();  // Handle FXML loading exceptions
        }
    }
}
