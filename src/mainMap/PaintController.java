package mainMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
    @FXML
    Button undoShapeButton;

    Shape copyShape;
    Shape undoShape;
    GraphicsContext gc;
    PaintModel paintmodel;
    public inputFromButtons userChoice = inputFromButtons.CIRCLE;
    PaintSaveFile save;

    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        slider.setMax(100);
        slider.setMin(10);
        slider.setValue(10);
        colorPicker.setValue(BLACK);
        textFieldSlider.textProperty().bind(slider.valueProperty().asString());
    }

    public PaintController(PaintModel paintmodel, PaintSaveFile save){
        this.paintmodel = paintmodel;
        this.save = save;
    }

    public void mouseClickInCanvas(MouseEvent event){
       double x = event.getX();
       double y = event.getY();

       if (event.getButton() == MouseButton.SECONDARY) {
           undoSaveObject(x,y);
           changeColorWithColorPicker(x, y);
           changeSizeWithSlider(x, y);
       } else {
           switch (userChoice) {
               case CIRCLE:
                   createCircle(x, y);
                   break;
               case RECTANGLE:
                   createRectangle(x, y);
                   break;
           }
       }
       drawShapesOnCanvas();
    }

    public void saveSVG(ActionEvent actionEvent) {
        save.saveSVGMethod(paintmodel);
    }

    public void undoLastShape(){
        if (paintmodel.getShapes().size() != 0) {
            paintmodel.getShapes().remove(paintmodel.shapes.size() -1);
            drawShapesOnCanvas();
        }
    }

    public void firstTobeCopy(Shape firstTobeCopy) {
        this.copyShape = firstTobeCopy;
        this.undoShape = firstTobeCopy.deepCopy();
    }

    private void undoSaveObject(double x, double y){
        paintmodel.getShapes().stream()
                .filter(s -> s.intersects(x, y)).map(drawableInterface -> (Shape) drawableInterface)
                .findFirst().ifPresent(s -> firstTobeCopy(s));
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

    public void mCircleButton(){
        userChoice = userChoice.CIRCLE;
    }
    private void createCircle(double x, double y) {
        CircleClass circle = new CircleClass(x, y, slider.getValue(), colorPicker.getValue());
        paintmodel.saveShapeToObserveList(circle);
    }

    public void mRectangleButton(){
        userChoice = userChoice.RECTANGLE;
    }
    private void createRectangle(double x, double y) {
        RectangleClass rectangle = new RectangleClass(x, y, slider.getValue(), slider.getValue(), colorPicker.getValue());
        paintmodel.saveShapeToObserveList(rectangle);
    }

    public void drawShapesOnCanvas() {
        cleanCanvas();
        for (DrawableInterface shape : paintmodel.getShapes()) {
            shape.draw(gc, false);
        }
    }

    private void cleanCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.DARKBLUE);
    }

    public void setColorWithColorpicker(ActionEvent actionEvent) {
        Color c = colorPicker.getValue();
        gc.setStroke(c);
        gc.setFill(c);
    }

    public void undo(){
        int index = paintmodel.getShapes().indexOf(copyShape);
        if (index >= 0) {
            paintmodel.shapes.remove(index);
            paintmodel.shapes.add(index, undoShape);
            drawShapesOnCanvas();
        }
    }

    enum inputFromButtons {
        CIRCLE,
        RECTANGLE,
        DEFAULT
    }

    public void EXIT() {
        System.exit(38832);
    }
}

