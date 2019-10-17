package shapesmap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class RectangleClass extends Shape {

    private double height;
    private double lenght;

    public RectangleClass() {
    }

    public RectangleClass(double x, double y, double height, double lenght, Paint paint) {
        super.setXpos(x);
        super.setYpos(y);
        this.height = height;
        this.lenght = lenght;
        super.setPaint(paint);
    }

    @Override
    public String stringSVGFormat() {
        return "<rect x=\"" + (getXpos() - (getHeight()/2))  + "\" " + "y=\"" + (getYpos() -  (getHeight()/2)) + "\" " + "width=\"" + getLenght()
                + "\" " + "height=\"" + getHeight() + "\" " + "fill=\"" + "#" + getPaint().toString().substring(2, 8) + "\"/>";
    }

    @Override
    public void draw(GraphicsContext gc, boolean stroke) {
            gc.setFill(getPaint());
            gc.fillRect(getXpos() - (getHeight() / 2), getYpos() - (getLenght() / 2), getHeight(), getLenght());
    }

    @Override
    public boolean intersects(double x, double y) {

        if (x >= (getXpos() - (getLenght()/2)) && x <= (getXpos() + getLenght()/2)
         && y >= (getYpos() - getHeight()/2)   && y <= (getYpos() + getHeight()/2))
            return true;
        else {
            return false;
        }
    }

    public void setSize(double x) {
        this.height = x;
        this.lenght = x;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    @Override
    public String toString() {
        return "RectangleClass{" +
                "height=" + height +
                ", lenght=" + lenght +
                '}';
    }
}







