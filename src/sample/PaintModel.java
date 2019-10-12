package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shapesmap.DrawableInterface;
import shapesmap.Shape;

public class PaintModel {

    ObservableList<DrawableInterface> shapes;

    StringProperty textForSlider = new SimpleStringProperty();
    public String getTextForSlider() {
        return textForSlider.get();
    }

    public StringProperty textForSliderProperty() {
        return textForSlider;
    }

    public void setTextForSlider(String textForSlider) {
        this.textForSlider.set(textForSlider);
    }

    public PaintModel() {
        this.shapes = FXCollections.observableArrayList();
    }

    public void saveShapeToObserveList(Shape shape){
    this.shapes.add(shape);
    }

    public ObservableList<DrawableInterface> getShapes() {
        return shapes;
    }

    public void setShapes(ObservableList<DrawableInterface> shapes) {
        this.shapes = shapes;
    }
}
