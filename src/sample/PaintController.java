package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import shapesmap.CircleClass;
import shapesmap.DrawableInterface;
import shapesmap.RectangleClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static javafx.scene.paint.Color.BLACK;

public class PaintController {

    @FXML
    Button undoButton;
    @FXML
    Canvas canvas;
    @FXML
    Slider slider;
    @FXML
    ColorPicker colorPicker;
    @FXML
    MenuItem circle;
    @FXML
    MenuItem rectangle;
    @FXML
    TextField textFieldSlider;

    GraphicsContext gc;
    public inputFromButtons userChoice = inputFromButtons.DEFAULT;
    PaintModel paintmodel;

    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        slider.setMax(200);
        slider.setMin(5);
        slider.setValue(5);
        slider.showTickMarksProperty();
        colorPicker.setValue(BLACK);
    }

    public void mouseClickInCanvas(MouseEvent event){

       double x = event.getX();
       double y = event.getY();

       if (event.getButton() == MouseButton.SECONDARY) {
           changeColorWithColorPicker(x, y);
           changeSizeWithSlider(x, y);
           System.out.println("högerkklick");
           drawAllMadeShapes();
       } else {
           System.out.println("vänsterklick");

           switch (userChoice) {

               case CIRCLE:
                   createCircle(x, y);
                   drawAllMadeShapes();
                   break;

               case RECTANGLE:
                   createRectangle(x, y);
                   drawAllMadeShapes();
                   break;
               default:
                   userChoice = userChoice.DEFAULT;
                   break;
           }
       }
    }

    private void changeSizeWithSlider(double x, double y) {
        paintmodel.getShapes().stream()
                .filter(s -> s.intersects(x, y))
                .findFirst().ifPresent( s -> s.setSize(slider.getValue()));
    }

    private void changeColorWithColorPicker(double x, double y) {
        paintmodel.getShapes().stream()
                .filter(s -> s.intersects(x, y))
                .findFirst().ifPresent( s -> s.setPaint(colorPicker.getValue()));
    }

    private CircleClass createCircle(double x, double y) {
        CircleClass cirkelttest = new CircleClass();
        cirkelttest.setXpos(x);
        cirkelttest.setYpos(y);
        cirkelttest.setDiameter(slider.getValue());
        cirkelttest.setPaint(colorPicker.getValue());
        paintmodel.saveShapeToObserveList(cirkelttest);
        return cirkelttest;
    }

    private void createRectangle(double x, double y) {
        RectangleClass rektangeltest = new RectangleClass();
        rektangeltest.setXpos(x);
        rektangeltest.setYpos(y);
        rektangeltest.setHeight(slider.getValue());
        rektangeltest.setLenght(slider.getValue());
        rektangeltest.setPaint(colorPicker.getValue());
        paintmodel.saveShapeToObserveList(rektangeltest);
    }

    public void drawAllMadeShapes() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.DARKBLUE);

        for (DrawableInterface shape : paintmodel.getShapes()) {
            shape.draw(gc, false);
        }
    }

    enum inputFromButtons {
        CIRCLE,
        RECTANGLE,
        DEFAULT
    }

    public void mCircleButton(){
        userChoice = userChoice.CIRCLE;
    }
    public void mRectangleButton(){
        userChoice = userChoice.RECTANGLE;
    }
    public PaintController(PaintModel paintmodel){
        this.paintmodel = paintmodel;
    }

    public void changeColor(ActionEvent actionEvent) {
        Color c = colorPicker.getValue();
        gc.setStroke(c);
        gc.setFill(c);
    }

    public void EXIT(ActionEvent actionEvent) {
        System.exit(444);
    }

    public void saveSVG(){
        String path = System.getProperty("user.home") +
                File.separator + "Documents" +
                File.separator + "CustomFolder";

        File filePath = new File(path + File.separator + "BildfilSVG.svg");

        try (FileWriter out = new FileWriter(filePath)){
            out.write("<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                    "<svg width=\"410\" height=\"640\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">" +"\n");
            paintmodel.getShapes().stream().forEach(s -> {
                try {
                    out.write(s.printToSVGFromString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.write("</svg>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void undo(){
        paintmodel.getShapes().remove(paintmodel.shapes.size() -1);
        drawAllMadeShapes();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

}

