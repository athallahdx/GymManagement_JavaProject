module GymManagement {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;

    exports com.model; // Export your model package if it contains public classes used outside
    exports com.util; // Export the util package if it contains public classes used outside

    opens com.model to javafx.graphics, javafx.fxml, javafx.controls, com.util.DatabaseConnection; // If you have any FXML or other elements here;
    opens com.util to javafx.fxml; // If you have any FXML or other elements here
}
