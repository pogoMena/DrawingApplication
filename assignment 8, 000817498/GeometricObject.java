package (assignment 8, 000817498);
/**
 * Abstract class that holds the parent object "Geometric object" which all of the shapes are children of
 * @author Michael Mena 000817498
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class GeometricObject {
    /**
     * point on the x axis where the objects will start
     */
    public double x;
    /**
     * point on the y axis where the objects will start
     */
    public double y;
    /**
     * Color that the stoke of all shapes will be
     */
    public Color lineColor;
    /**
     * Width of the lines that the shapes will use
     */
    public double strokeWidth;

    /**
     * Sets the linecolor variable
     * @param lineColor the color of the line
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     * Sets the value of x
     * @param x the value that will be set as x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets the value of y
     * @param y the value that will be set as x
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Sets the value of strokeWidth
     * @param strokeWidth the width that will be set as the stroke
     */
    public void setStrokeWidth(double strokeWidth){
        this.strokeWidth = strokeWidth;
    }

    /**
     * gets the line color
     * @return returns the color of the line
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     * gets the value of x
     * @return returns the value of x
     */
    public double getX() {
        return x;
    }

    /**
     * gets the value of y
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * an abstract class that is used to draw all objects
     * @param gc the Graphic Context used with the GUI
     */
    public abstract void draw(GraphicsContext gc);

}
