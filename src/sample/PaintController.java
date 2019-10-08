package sample;
import com.sun.javafx.css.StyleCache;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;


public class PaintController {

    @FXML
    ColorPicker colorPicker;
    @FXML
    Button PointButton;
    @FXML
    Button LineButton;
    @FXML
    Canvas thisCanvas;




    GraphicsContext gc;



    PaintModel model = new PaintModel();


    public void drawMethod(){



    }
    public void initialize() {

    }

    public void whenButtonPressed(){
        String s = "this is shooot";
        model.textProperty().set(s);


    }


    public void buttonLineAction(ActionEvent actionEvent) {
    LineButton.setText("DUMBASS");    }


    public void buttonPointButton(ActionEvent actionEvent) {
    }
}
