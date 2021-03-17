package (assignment 8, 000817498);
/**
 * Rectangle class which holds the parameters and draws the "Rectangle" object
 * @author Michael Mena
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends GeometricObject {

    /**
     * the width of the Rectangle
     */
        public double xWidth;
    /**
     * the height of the Rectangle
     */
        public double yWidth;

    /**
     * The fill color for the rectangle
     */
    public Color fillColor;

    /**
     * The constructor for the Rectangle object
     * @param x the x axis where it starts
     * @param y the y axis where it starts
     * @param xWidth the width of the rectangle
     * @param yWidth the height of the rectangle
     * @param fillColor the fill color of the Rectangle
     * @param lineColor the Line color of the Rectangle
     * @param strokeWidth the Line width of the outline of the rectangle
     */
        public Rectangle(double x, double y, double xWidth, double yWidth, Color fillColor, Color lineColor, double strokeWidth){
            this.xWidth = xWidth;
            this.yWidth = yWidth;
            this.fillColor=fillColor;
            super.setLineColor(lineColor);
            super.setX(x);
            super.setY(y);
            super.setStrokeWidth(strokeWidth);

        }


    /**
     * Sets the color of the outline
     * @param lineColor the color of the line
     */
    @Override
        public void setLineColor(Color lineColor) {
            super.setLineColor(lineColor);
        }


    /**
     * Draws the rectangle
     * @param gc the Graphic Context used with the GUI
     */
    public void draw(GraphicsContext gc){
            gc.setLineWidth(strokeWidth);
            gc.setStroke(lineColor);
            gc.setFill(fillColor);
            gc.setFill(fillColor);
            gc.fillRect(x,y,xWidth,yWidth);
            gc.strokeRect(x,y,xWidth,yWidth);


        }
    }
