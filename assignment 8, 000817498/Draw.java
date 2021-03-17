package (assignment 8, 000817498);
/**
 * Draw class which holds all of the gui components and draws everything that is part of the program
 * @author Michael Mena
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class Draw extends Application {

    /**
     * the arrayList which holds all of the geometric objects
     */
    public ArrayList<GeometricObject> shapes = new ArrayList<>();
    /**
     * counter which keeps track of which the last object created was
     */
    public int counter = 0;
    /**
     * label which holds the current shape being created
     */
    Label shape;
    /**
     * Label that holds the color used to fill the shapes
     */
    Label fillHolder;
    /**
     * Label that holds the color to be used for the outline
     */
    Label lineHolder;
    /**
     * Color that will be used to fill the shapes
     */
    Color fill;
    /**
     * Color that will be used for the outline of the shapes and the color of the line
     */
    Color outLine;
    /**
     * The method used to select colors for the Fill and outLine
     */
    ColorPicker cp1;
    /**
     * The spot on the x axis that the mouse first clicks on
     */
    double x1;
    /**
     * The spot on the x axis that the mouse releases on
     */
    double x2;
    /**
     * The spot on the y axis that the mouse first clicks on
     */
    double y1;
    /**
     * The spot on the y axis that the mouse releases on
     */
    double y2;
    /**
     * the canvas that gets drawn on
     */
    Canvas canvas;
    /**
     * Button that removes the last item created
     */
    Button removeLast;
    /**
     * Text field where the user can specify the Stroke width
     */
    TextField strokeWidth;
    /**
     * variable that holds the contests test by the strokeWidth field
     */
    Double widthHolder = 1.0;



    /**
     * Sets the next shape that will be created to "Line"
     */
    public void setLine(ActionEvent e){
        shape.setText("Line");
    }
    /**
     * Sets the next shape that will be created to "Circle"
     */
    public void setCircle(ActionEvent e){
        shape.setText("Circle");
    }
    /**
     * Sets the next shape that will be created to "Rectangle"
     */
    public void setRectangle(ActionEvent e){
        shape.setText("Rectangle");
    }

    /**
     * Sets the color that will be used to fill shapes
     * @param e Action event
     */
    public void setFillHolder(ActionEvent e){
        fillHolder.setText(String.valueOf(cp1.getValue()));
        fill = cp1.getValue();

    }

    /**
     * Sets the color that will be used to outline and draw lines
     * @param e Action event
     */
    public void setLineHolder(ActionEvent e){
        lineHolder.setText(String.valueOf(cp1.getValue()));
        outLine = cp1.getValue();
    }


    /**
     * Removes the last object that was created
     * @param e Action event
     */
    public void remove(ActionEvent e){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if (counter >0) {

            counter--;
            shapes.remove(counter);
        }
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,1000,1000);
        for (GeometricObject g : shapes){
            g.draw(gc);
        }
    }

    /**
     * Sets the width of the outline of shapes, and the Line object
     * @param e Action Event
     */
    public void setStrokeWidth(ActionEvent e){
        GraphicsContext gc = canvas.getGraphicsContext2D();

        try {
            widthHolder = (Double.parseDouble(strokeWidth.getText()));
        } catch (NumberFormatException f) {
            new Alert(Alert.AlertType.WARNING,"Invalid line width").showAndWait();
        }


    }

    /**
     * Handles when the mouse is clicked and sets x1 and y1 to the location where it happened
     * @param me Mouse Event
     */
    public void pressHandler(MouseEvent me){
        x1 = me.getX();
        y1 = me.getY();


    }


    /**
     * Handles when the mouse is released and sets x2 and y2 to the location where it happend
     * @param me
     */
    public void releaseHandler(MouseEvent me){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        x2 = me.getX();
        y2 = me.getY();
        double x2Shape = 0;
        double y2Shape = 0;

        /**
         * Checks the shape field and draws a Line and adds it to the Shapes array
         */
        if(shape.getText().equals("Line")){
            GeometricObject temp = new Line(x1, y1, x2, y2, outLine, widthHolder);
            shapes.add(temp);
            //shapes.get(counter).draw(gc);
            counter ++;
        }
        /**
         * Checks the shape field and draws a Circle and adds it to the Shapes array
         * If x2 or y2 is lower in value than x1 or y1, then it changes the coordinates so the object draws it accordingly
         */
        else if (shape.getText().equals("Circle")){
            x2Shape = x2 - x1;
            y2Shape = y2-y1;

            if(x1>x2){
                x2Shape = x1-x2;
                x1-=x2Shape;
            }

            if(y1>y2){
                y2Shape = y1-y2;
                y1 -= y2Shape;
            }

            GeometricObject temp = new Circle(x1, y1, x2Shape, y2Shape, fill, outLine, widthHolder);
            shapes.add(temp);

            counter ++;
        }

        /**
         * Checks the shape field and draws a Rectangle and adds it to the Shapes array
         * If x2 or y2 is lower in value than x1 or y1, then it changes the coordinates so the object draws it accordingly
         */
        else if (shape.getText().equals("Rectangle")){
            x2Shape = x2 - x1;
            y2Shape = y2-y1;

            //something needs to happen to fix x1
            if(x1>x2){
                x2Shape = x1-x2;
                x1-=x2Shape;
            }

            if(y1>y2){
                y2Shape = y1-y2;
                y1 -= y2Shape;
            }

            GeometricObject temp = new Rectangle(x1, y1, x2Shape, y2Shape, fill, outLine, widthHolder);
            shapes.add(temp);

            //how to cast here
            //shapes.get(counter).draw(gc);
            counter ++;
        }

        /**
         * makes the canvas blank again and redraws all of the objects
         */
        gc.setFill(Color.WHITE);
        gc.fillRect(0,0,1000,1000);
        for (GeometricObject g : shapes){
            g.draw(gc);
        }


    }

    /**
     *Starts the Gui which runs the program
     * @param stage Sets the stage
     */
    public void start(Stage stage) {

        /**
         * the Pane that holds all components
         */
        Pane root = new Pane();
        /**
         * sets the scene as 2000 by 2000
         */
        Scene scene = new Scene(root, 2000, 2000);
        /**
         * Names the program
         */
        stage.setTitle("Photoshop by Michael");
        /**
         * sets the scene on the stage
         */
        stage.setScene(scene);
        /**
         * Makes a canvas that is 1000 by 1000
         */
        canvas = new Canvas(1000, 1000);
        /**
         * Creates a color picker
         */
        cp1 = new ColorPicker(Color.BLUE);
        /**
         * sets the fill holder label as blank
         */
        fillHolder = new Label("  ---  ");
        /**
         * Sets the lineholder label to blank
         */
        lineHolder = new Label("  ---  ");
        /**
         * Sets the shape Label to the default "Line" shape
         */
        shape = new Label("Line");
        /**
         * sets the Button to remove the last Item
         */
        removeLast = new Button("Remove Last");
        /**
         * creates the Button that sets the stroke width
         */
        Button strokeHolder = new Button("Set stroke width");
        /**
         * Text field where the user can set the stroke width
         */
        strokeWidth = new TextField("1");

        /**
         * Creates the button that selects "Circle"
         */
        Button circleSelect = new Button("Circle");
        /**
         * Creates the button that selects "Rectangle"
         */

        Button rectangleSelect = new Button("Rectangle");
        /**
         * Creates the button that selects "Line"
         */
        Button lineSelect = new Button("Line");

        /**
         * Sets the Fill color of the Next shape
         */
        Button setFill = new Button("Set Fill Color");

        /**
         * Holds the color that will full the next shape
         */
        Button setLineColor = new Button("Set Line color");


        /**
         * Sets all of the gui components into the Pane
         */
        root.getChildren().addAll(canvas, setFill, setLineColor, cp1, fillHolder, lineHolder, shape, circleSelect, rectangleSelect, lineSelect, removeLast, strokeHolder, strokeWidth);

        /**
         * Shapes and places the setFill button
         */
        setFill.setPrefWidth(150);
        setFill.setPrefHeight(30);
        setFill.relocate(0, 0);

        /**
         * shapes and relocates the Shape Label
         */
        shape.setPrefWidth(150);
        shape.relocate(0, 180);

        /**
         * relocates the canvas
         */
        canvas.relocate(150, 0);

        /**
         * relocates the remove last button
         */
        removeLast.relocate(0,210);

        /**
         * relocates the Stroke holder button
         */
        strokeHolder.relocate(0,240);

        /**
         * shapes and relocates the Stroke width text field
         */
        strokeWidth.setPrefWidth(150);
        strokeWidth.relocate(0,270);

        /**
         * places the Fill holder label
         */
        fillHolder.relocate(150, 0);


        /**
         * Shapes and places the setLineColor Button
         */
        setLineColor.setPrefWidth(150);
        setLineColor.setPrefHeight(30);
        setLineColor.relocate(0,30);

        /**
         * places the line holder label
         */
        lineHolder.relocate(150, 30);

        /**
         * relocates the Color picker
         */
        cp1.relocate(0, 60);

        /**
         * relocates and shapes the different shape buttons
         */
        circleSelect.relocate(0, 90);
        circleSelect.setPrefWidth(150);
        rectangleSelect.relocate(0, 120);
        rectangleSelect.setPrefWidth(150);
        lineSelect.relocate(0, 150);
        lineSelect.setPrefWidth(150);


        /**
         * sets the mouse events
         */
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);

        /**
         * sets the shape select buttons actions
         */
        circleSelect.setOnAction(this::setCircle);
        rectangleSelect.setOnAction(this::setRectangle);
        lineSelect.setOnAction(this::setLine);

        /**
         * gives action to the set Color buttons
         */
        setFill.setOnAction(this::setFillHolder);
        setLineColor.setOnAction((this::setLineHolder));

        /**
         * gives action to the remove last button
         */
        removeLast.setOnAction(this::remove);

        /**
         * gives action to the strokeHolder button
         */
        strokeHolder.setOnAction(this::setStrokeWidth);


        /**
         * Starts the entire program
         */
        stage.show();

    }


}
