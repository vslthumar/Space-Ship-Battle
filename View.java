
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This is the view class which takes input from user, converts values into
 * integers, calculates output by calling methods from Model class, and draws
 * graphical output into the screen.
 *
 * @author Vishal Thumar
 */
public class View extends Application {

    /**
     * Label declaration for rows
     */
    private Label rowLabel,
            /**
             * Label declaration for columns
             */
            columnLabel,
            /**
             * Label declaration for score
             */
            scoreLabel,
            /**
             * Label declaration for lives
             */
            livesLabel,
            /**
             * Label declaration for x-position of player's spaceship
             */
            xLocationLabel,
            /**
             * Label declaration for color
             */
            colorLabel,
            /**
             * Label declaration for red color
             */
            redLabel,
            /**
             * Label declaration for green color
             */
            greenLabel,
            /**
             * Label declaration for blue color
             */
            blueLabel,
            /**
             * Label declaration for color range
             */
            colorRangeLabel;

    /**
     * Text field declaration for rows
     */
    private TextField rowTextField,
            /**
             * Text field declaration for columns
             */
            columnTextField,
            /**
             * Text field declaration for score
             */
            scoreTextField,
            /**
             * Text field declaration for lives
             */
            livesTextField,
            /**
             * Text field declaration for x-position of player's spaceship
             */
            xLocationTextField,
            /**
             * Text field declaration for value of red color
             */
            redTextField,
            /**
             * Text field declaration for value of green color
             */
            greenTextField,
            /**
             * Text field declaration for value of blue color
             */
            blueTextField;

    /**
     * Object made of Model class
     */
    private Model model;

    /**
     * Declaration of an object of GraphicsContext class
     */
    private GraphicsContext gc;

    /**
     * onClick method for the output when button is clicked
     *
     * @param stage The main stage
     * @throws Exception
     */
    private void onClick(ActionEvent e) {

        //instance variables for the all fields to store values from all the text fields by converting into integer values
        int rows = Integer.parseInt(rowTextField.getText());
        int columns = Integer.parseInt(columnTextField.getText());
        int score = Integer.parseInt(scoreTextField.getText());
        int lives = Integer.parseInt(livesTextField.getText());
        int xPositionPlayerSpaceship = Integer.parseInt(xLocationTextField.getText());
        int red = Integer.parseInt(redTextField.getText());
        int green = Integer.parseInt(greenTextField.getText());
        int blue = Integer.parseInt(blueTextField.getText());

        model = new Model(rows, columns, score, lives, xPositionPlayerSpaceship, red, green, blue); //called Model object with the values which user entered in text fields

        //set max range for all input values of text fields for proper output
        if (rows <= 10 && columns <= 12 && score <= 1000000 && lives <= 3 && xPositionPlayerSpaceship <= 620 && red <= 255 && green <= 255 && blue <= 255) {
            model.draw(gc);
        }
    }

    //start method with Stage parameter for graphical output in GUI format
    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();
        Scene scene = new Scene(root, 650, 950); // the size 
        stage.setTitle("Space Invaders Screen"); // the window title 
        stage.setScene(scene);
        Canvas canvas = new Canvas(650, 650);// Canvas declaration with it's size

        //Declaration of Labels, a button and initial values of Text Fields
        rowLabel = new Label("Rows of alien spaceships(1 to 10):");
        rowTextField = new TextField("10");
        columnLabel = new Label("Columns of alien spaceships(1 to 12):");
        columnTextField = new TextField("12");
        scoreLabel = new Label("Score of the player(0 to 1000000):");
        scoreTextField = new TextField("1000000");
        livesLabel = new Label("Remaining lives of the player(0 to 3):");
        livesTextField = new TextField("3");
        xLocationLabel = new Label("X-location of player's spaceship(0 to 620):");
        xLocationTextField = new TextField("0");
        colorLabel = new Label("RGB color values of player's spaceship-");
        colorRangeLabel = new Label("(0 to 255 for each of the RGB values)");
        redLabel = new Label("Red:");
        redTextField = new TextField("255");
        greenLabel = new Label("Green:");
        greenTextField = new TextField("255");
        blueLabel = new Label("Blue:");
        blueTextField = new TextField("255");
        Button submitButton = new Button("Submit all values");

        //Added all the parameters into the GUI screen
        root.getChildren().addAll(rowLabel, columnLabel, scoreLabel, livesLabel, xLocationLabel, colorLabel, redLabel, greenLabel, blueLabel, colorRangeLabel, rowTextField, columnTextField, scoreTextField, livesTextField, xLocationTextField, redTextField, greenTextField, blueTextField, submitButton, canvas);

        //Relocated all the fields in GUI screen
        rowLabel.relocate(5, 20);
        columnLabel.relocate(5, 50);
        scoreLabel.relocate(5, 80);
        livesLabel.relocate(5, 110);
        xLocationLabel.relocate(5, 140);
        colorLabel.relocate(5, 170);
        colorRangeLabel.relocate(5, 190);
        redLabel.relocate(210, 170);
        greenLabel.relocate(210, 200);
        blueLabel.relocate(210, 230);
        rowTextField.relocate(200, 15);
        columnTextField.relocate(210, 45);
        scoreTextField.relocate(200, 75);
        livesTextField.relocate(210, 105);
        xLocationTextField.relocate(230, 135);
        redTextField.relocate(240, 165);
        greenTextField.relocate(250, 195);
        blueTextField.relocate(250, 225);
        submitButton.relocate(500, 225);
        canvas.relocate(0, 300);

        submitButton.setOnAction(this::onClick);//Action event calling when button is clicked
        gc = canvas.getGraphicsContext2D();//Graphics context added to 2D Canvas
        model = new Model(0, 0, 0, 0, 0, 0, 0, 0);// Initial values of graphical output
        model.draw(gc);//draws the output by calling draw method of Model class

        stage.show();
    }

    /**
     *
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
