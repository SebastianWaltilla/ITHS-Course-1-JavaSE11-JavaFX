package shapesmap;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class RectangleClass extends Shape {

    private double height;
    private double lenght;

    public RectangleClass() {


    }

    @Override
    public String printToSVGFromString() {
        return "<rect x=\"" + getXpos() + "\" " + "y=\"" + getYpos() + "\" " + "width=\"" + getLenght()
                + "\" " + "height=\"" + getHeight() + "\" " + "fill=\"" + "#" + getPaint().toString().substring(2, 8) + "\"/>";
    }

    public void setSize(double x) {
        this.height = x;
        this.lenght = x;
    }

    public RectangleClass(double height, double lenght) {
        this.height = height;
        this.lenght = lenght;
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
    public void draw(GraphicsContext gc, boolean stroke) {

        if (stroke)
            gc.strokeRect(getXpos(), getXpos(), getHeight(), getLenght());
        else {
            gc.setFill(getPaint());
            gc.fillRect(getXpos() - (getHeight() / 2), getYpos() - (getLenght() / 2), getHeight(), getLenght());
        }
    }

    public boolean intersects(double x, double y) {
        double x1 = getXpos() - (getLenght()/2);
        double x2 = getXpos() + getLenght()/2;
        double y1 = getYpos() - getHeight()/2;
        double y2 = getYpos() + getHeight()/2;
        if (x >= x1 && x <= x2 && y >= y1 && y <= y2)
            return true;
        else {
            return false;
        }
    }

}
    /*
    public boolean intersects(double x, double y) {


        if (x > getXpos() - (getLenght() /2 )              &&      x < (   (getXpos() + getLenght()) - ( getLenght() - (getLenght() / 2))   ) &&
            y < getYpos() - (getHeight() / 2 )            &&      y < (    (getYpos() + getHeight()) - (getHeight()  - (getLenght() /2)    ))) {
            return true;
        } else {
            return false;
        }


    }
/*

        double r = getDiameter();
        double x2 = (x - getXpos());
        double y2 = (y - getYpos());
        if ((x2 * x2 + y2 * y2) < r * r)
            return true;
        return false;
    }
    }









/*
    @Override
    public void draw(GraphicsContext gc, boolean stroke) {
        super.draw(gc, stroke);
    }
       gc.fillOval(e.getX(), e.getY(), 15 + slider.getValue(), 15 + slider.getValue()));


        gc.strokeOval(getXpos() - getRadius(), getYpos() - getRadius(), getRadius() * 2.0, getRadius() * 2.0);
        else {
        gc.setFill(getPaint());
        gc.fillOval(getXpos() - getRadius(), getYpos() - getRadius(), getRadius() * 2.0, getRadius() * 2.0);
    }


*/



