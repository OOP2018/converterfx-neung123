package converter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main Class for call and connect everything.
 *
 * @author Pornpavee Seri-umnuoy
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            Parent root = (Parent)FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Simple Converter");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e){
            System.out.println("Exception creating scene: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
