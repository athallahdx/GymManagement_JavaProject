module GymManagement {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.sql;

    // Export your packages so that other modules or parts of your application can access them
    exports com.model;
    exports com.util;
    exports com.controller; // Add this line to export your controller

    // You need to open these packages to JavaFX runtime for reflection (like FXML loading)
    opens com.controller to javafx.fxml;
    opens com.model to javafx.fxml; // Open your model package to JavaFX if it's needed for FXML
    opens com.util to javafx.fxml;  // Open util package if it is accessed via reflection (though not necessary unless reflection-based)
}
