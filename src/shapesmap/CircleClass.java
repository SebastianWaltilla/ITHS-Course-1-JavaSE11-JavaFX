package shapesmap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

public class CircleClass extends Shape {

    private double diameter;

    public CircleClass  (){
    }

    public CircleClass(double x, double y, double diameter, Paint paint) {
        super.setXpos(x);
        super.setYpos(y);
        this.diameter = diameter;
        super.setPaint(paint);
    }

    @Override
    public String stringSVGFormat(){
        return "<circle cx=" + "\"" + getXpos()  + "\"" + " "+"cy="+ "\""+ getYpos() + "\""+" "+ "r="+"\""+( getDiameter() /2 )+ "\"" +" "+ "fill="+"\""+ "#" +getPaint().toString().substring(2,8)+"\""+"/>";
    }

    @Override
    public boolean intersects(double x, double y) {         
        double r = getDiameter();
        double x2 = (x - getXpos());
        double y2 = (y - getYpos());
        if ((x2 * x2 + y2 * y2) < r * r) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void draw(GraphicsContext gc,  boolean stroke) {
            gc.setFill(getPaint());
            gc.fillOval(getXpos() - (diameter / 2), getYpos() - (diameter /2), getDiameter(), getDiameter());
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void setSize(double x){
        this.diameter = x;
    }

    @Override
    public String toString() {
        return "CircleClass{" +
                "diameter=" + diameter +
                '}';
    }
}
