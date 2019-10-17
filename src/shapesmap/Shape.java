package shapesmap;

import javafx.beans.property.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
public class Shape implements DrawableInterface {

    private DoubleProperty xpos = new SimpleDoubleProperty();
    private DoubleProperty ypos = new SimpleDoubleProperty();
    private ObjectProperty<Paint> paint = new SimpleObjectProperty<>();



    private IntegerProperty hej;


    @Override
    public void setSize(double x) {

    }

    @Override
    public String stringSVGFormat() {
        return null;
    }

    @Override
    public void setXpos(double xpos) {
    this.xpos.setValue(xpos);
    }

    @Override
    public void setYpos(double ypos) {
    this.ypos.setValue(ypos);
    }

    @Override
    public double getXpos() {
        return xpos.get();
    }

    @Override
    public DoubleProperty xposProperty() {
        return null;
    }

    @Override
    public double getYpos() {
        return ypos.get();
    }

    @Override
    public DoubleProperty yposProperty() {
        return null;
    }

    @Override
    public void draw(GraphicsContext gc, boolean stroke) {

    }

    @Override
    public Paint getPaint() {
        return paint.get();
    }

    @Override
    public ObjectProperty<Paint> paintProperty() {
        return null;
    }

    @Override
    public void setPaint(Paint paint) {
    this.paint.set(paint);
    }

    @Override
    public boolean intersects(double x, double y) {
        return false;
    }
}
