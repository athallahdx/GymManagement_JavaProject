package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MemberManagement extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
    	try {
    		Parent root = FXMLLoader.load(getClass().getResource("/com/view/MemberView.fxml"));
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
