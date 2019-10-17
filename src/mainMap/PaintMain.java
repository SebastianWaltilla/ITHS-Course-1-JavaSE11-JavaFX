package mainMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaintMain extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PaintView.fxml"));
        PaintModel paintmodel = new PaintModel();
        PaintSaveFile save = new PaintSaveFile();
        loader.setControllerFactory(param -> new PaintController(paintmodel, save));
        Parent root = loader.load();
        primaryStage.setTitle("PaintFX");
        primaryStage.setScene(new Scene(root, 410 , 640));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

