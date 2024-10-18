module GymManagement {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.sql;
	
	exports com.util.DatabaseConnection;
	
	opens application to javafx.graphics, javafx.fxml;
	opens com.model to javafx.graphics, javafx.fxml;
}
