package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import javax.swing.*;


public class PaintController {

    @FXML
    ColorPicker colorPicker;
    @FXML
    Button PointButton;
    @FXML
    Button LineButton;
    @FXML
    Canvas canvas;
    @FXML
    Slider slider;
    @FXML
    MenuItem circle;



    int pressedButton = 0; // 1 = drawLine, 2 = Make Circle, 3 = Make Square


    GraphicsContext gc;




    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        slider.setMax(80);
        slider.setMin(1);
        slider.showTickMarksProperty();
    }
/*

    public void whatToDraw(){

        if (pressedButton == 1){
            drawLine();
        }else(pressedButton == 2){

        }

    }

*/

    public void drawLine(){

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(slider.getValue());

        canvas.setOnMousePressed( E-> {
            gc.beginPath();
            gc.lineTo(E.getX(), E.getY());
            gc.stroke();
        });

        canvas.setOnMouseDragged(E ->{
            gc.lineTo(E.getX(), E.getY());
            gc.stroke();
        });

    }

    /*

     //     En Switchsats för att
    public void whenButtonPressed(){

        //Regular Drawing (setOnMousePressed)

        canvas.setOnMousePressed(e->{
            switch (pressedButton)
            case 1:

                gc.setStroke(cpLine.getValue());
                gc.beginPath();
                gc.lineTo(e.getX(), e.getY());
            }
            else if(linebtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                line.setStartX(e.getX());
                line.setStartY(e.getY());
            }

            else if(rectbtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                gc.setFill(cpFill.getValue());
                rect.setX(e.getX());
                rect.setY(e.getY());
            }

            else if(circbtn.isSelected()) {
                gc.setStroke(cpLine.getValue());
                gc.setFill(cpFill.getValue());
                circ.setCenterX(e.getX());
                circ.setCenterY(e.getY());
            }
        });
        //--------

    }
*/

    public void buttonLineAction(ActionEvent hej) {

    }


    public void ButtonPointButton() {
        drawLine();
    }

    public void createCircleMethod(ActionEvent actionEvent) {
        canvas.setOnMouseClicked( e-> {
            gc.fillOval(e.getX(), e.getY(), slider.getValue(),slider.getValue());
        });
    }


    public void changeColor(ActionEvent actionEvent) {
        Color c = colorPicker.getValue();
        gc.setStroke(c);
        gc.setFill(c);
    }


    public void EXIT(ActionEvent actionEvent) {
        System.exit(444);
    }
}

