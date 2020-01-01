package mainMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaintModel {

        ObservableList<DrawableInterface> shapes;

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
