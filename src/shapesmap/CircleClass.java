package shapesmap;
import javafx.scene.canvas.GraphicsContext;


public class CircleClass extends Shape {

    private double diameter;

    public CircleClass  (){

    }
    @Override
    public String printToSVGFromString(){
        return "<circle cx=" + "\"" + getXpos()+ "\"" + " "+"cy="+ "\""+getYpos()+ "\""+" "+ "r="+"\""+getDiameter()+"\"" +" "+ "fill="+"\""+ "#" +getPaint().toString().substring(2,8)+"\""+"/>";
    }

    @Override
    public boolean intersects(double x, double y) {
        //double
        double r = getDiameter();
        double x2 = (x - getXpos());
        double y2 = (y - getYpos());
        if ((x2 * x2 + y2 * y2) < r * r)
            return true;
        return false;
    }

    public CircleClass(double diameter) {
        this.diameter = diameter;
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


    // Override methods from interface Drawble


    @Override
    public void draw(GraphicsContext gc,  boolean stroke) {

        if (stroke)
            gc.strokeOval(getXpos(), getYpos(), getDiameter(), getDiameter());
       else{
        gc.setFill(getPaint());
        gc.fillOval(getXpos() - (diameter / 2), getYpos() - (diameter /2), getDiameter(), getDiameter());
        }
    }

    public boolean mouseClickOnCircle(double x, double y){

        double diameter = getDiameter();
        double cirkelX = getXpos();
        double cirkelY = getYpos();

        double musKlickX = x;
        double musKlickY = y;

        double liggerMusklickPåX = cirkelX - musKlickX;
        double liggerMusklickPåY = cirkelY - musKlickY;

        if (musKlickX + musKlickY < liggerMusklickPåX + liggerMusklickPåY){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "<circle cx=" + "\"" + getXpos()+ "\"" + " "+"cy="+ "\""+getYpos()+ "\""+" "+ "r="+"\""+getDiameter()+"\"" +" "+ "fill="+"\""+ "#" +getPaint().toString().substring(2,8)+"\""+"/>";
    }

    /*

    public boolean intersects(double x, double y) {
        //double
        double r = getRadius();
        double x2 = (x - getXpos());
        double y2 = (y - getYpos());
        if ((x2 * x2 + y2 * y2) < r * r)
            return true;
        return false;









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



}
