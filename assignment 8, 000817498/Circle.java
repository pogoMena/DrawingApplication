package (assignment 8, 000817498);
/**
 * Circle class which holds the parameters and draws the "Circle" object
 * @author Michael Mena
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends GeometricObject{
    /**
     * The radius of the circle on the x axis
     */
    public double xRadius;
    /**
     * the radius of the circle on the y axis
     */
    public double yRadius;
    /**
     * the color that will fill th circle
     */
    public Color fillColor;

    /**
     * The constructor of the circle object
     * @param x sets x
     * @param y sets y
     * @param xRadius sets the xRadius variable
     * @param yRadius sets the yRadius variable
     * @param fillColor sets the color to fill the circle
     * @param lineColor sets the outline color of the circle
     * @param strokeWidth sets the width of the line around the circle
     */
    public Circle(double x, double y, double xRadius, double yRadius, Color fillColor, Color lineColor, double strokeWidth){
        this.xRadius = xRadius;
        this.yRadius = yRadius;
        this.fillColor=fillColor;
        super.setLineColor(lineColor);
        super.setX(x);
        super.setY(y);
        super.setStrokeWidth(strokeWidth);

    }

    /**
     * set method for the line color variable
     * @param lineColor sets the color of the line
     */
    @Override
    public void setLineColor(Color lineColor) {
        super.setLineColor(lineColor);
    }


    /**
     * Draw method for the circle object
     * @param gc the Graphic Context used with the GUI
     */
    public void draw(GraphicsContext gc){
        gc.setLineWidth(strokeWidth);
        gc.setStroke(lineColor);
        gc.setFill(fillColor);
        gc.setFill(fillColor);
        gc.fillOval(x,y,xRadius,yRadius);
        gc.strokeOval(x,y,xRadius,yRadius);


    }
}
