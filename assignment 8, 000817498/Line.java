package (assignment 8, 000817498);
/**
 * Line class which holds the parameters and draws the "Line" object
 * @author Michael Mena
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends GeometricObject{
    /**
     * the spot on the x axis where the line ends
     */
    public double x2;
    /**
     * the spot on the y axis where the line ends
     */
    public double y2;

    /**
     * the constructor that creates the line object
     * @param x x axis start
     * @param y y axis start
     * @param x2 x axis end
     * @param y2 y axis end
     * @param lineColor Line color
     * @param strokeWidth Line width
     */
    public Line(double x, double y, double x2, double y2, Color lineColor, double strokeWidth){
    super.setX(x);
    super.setY(y);
    this.x2=x2;
    this.y2=y2;
    super.setLineColor(lineColor);
    super.setStrokeWidth(strokeWidth);
    }


    /**
     * method that draws the Line on the canvas
     * @param gc the Graphic Context used with the GUI
     */
    public void draw(GraphicsContext gc){
        gc.setLineWidth(strokeWidth);
        gc.setStroke(super.getLineColor());
        gc.strokeLine(super.getX(), super.getY(), x2,y2);
    }

}
