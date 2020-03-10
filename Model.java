
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*
 *This is the Model class which contains logic and calculates outcome as per user demand
 *by making a model, and used in the view/main class to get proper output.
 *
 * @author Vishal Thumar
 */
public class Model {

    /**
     * Declaration of variable for rows
     */
    private int rows,
            /**
             * Declaration of variable for columns
             */
            columns,
            /**
             * Declaration of variable for score
             */
            score,
            /**
             * Declaration of variable for lives
             */
            lives,
            /**
             * Declaration of variable for x-position of player's spaceship
             */
            xPositionPlayerSpaceship,
            /**
             * Declaration of variable for values of red color
             */
            red,
            /**
             * Declaration of variable for values of blue color
             */
            blue,
            /**
             * Declaration of variable for values of green color
             */
            green;

    /**
     * Constructor to get or set values of variables
     *
     * @param rows
     * @param columns
     * @param score
     * @param lives
     * @param xPositionPlayerSpaceship
     * @param red
     * @param green
     * @param blue
     */
    public Model(int rows, int columns, int score, int lives, int xPositionPlayerSpaceship, int red, int green, int blue) {
        this.rows = rows;
        this.columns = columns;
        this.score = score;
        this.lives = lives;
        this.xPositionPlayerSpaceship = xPositionPlayerSpaceship;
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    /**
     * draw method to prepare model of graphical output by calling
     * GraphicsContext class
     *
     * @param gc
     */
    public void draw(GraphicsContext gc) {

        //Declaration of instance variables and initializing values
        int y1PositionofAlienSpaceship = 0, x1PositionofAlienSpaceship = 0, y2PositionofAlienSpaceship = 0, x2PositionofAlienSpaceship = 0;

        //***set background color and it's size
        gc.setFill(Color.SKYBLUE);
        gc.fillRect(0, 0, 650, 650);

        //***shows score and remainining lives with proper colors
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("Calibri", 20));
        gc.fillText("Score: " + score, 5, 20);
        gc.fillText("LIVES:", 500, 20);

        for (int l = 0; l < lives; l++) {
            gc.setFill(Color.GREEN);
            gc.fillOval(550 + (l * 20), 10, 10, 10);
        }

        //***draws rows and columns of alien spaceships using user input.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                //***processing
                y1PositionofAlienSpaceship = 60 + i * 50;
                y2PositionofAlienSpaceship = 50 + i * 50;
                x1PositionofAlienSpaceship = 10 + j * 50;
                x2PositionofAlienSpaceship = 20 + j * 50;

                //***output
                gc.setFill(Color.WHITE);
                gc.setStroke(Color.RED);
                gc.setLineWidth(3);
                gc.strokeOval(x2PositionofAlienSpaceship, y2PositionofAlienSpaceship, 20, 20);
                gc.fillOval(x2PositionofAlienSpaceship, y2PositionofAlienSpaceship, 20, 20);
                gc.strokeOval(x1PositionofAlienSpaceship, y1PositionofAlienSpaceship, 40, 10);
                gc.fillOval(x1PositionofAlienSpaceship, y1PositionofAlienSpaceship, 40, 10);

            }
        }

        //***draws bullets, randomly placed between alien spaceship's bottom row and houses.
        int bullets;
        if (rows != 0 && columns != 0) {
            bullets = (int) (Math.random() * 3);

            for (int b = 1; b < 10 + bullets; b++) {
                int bulletsXPosition = (int) (Math.random() * x1PositionofAlienSpaceship);
                int bulletsYPosition = (int) (Math.random() * (555 - (y1PositionofAlienSpaceship + 20)));
                gc.setFill(Color.RED);
                gc.setStroke(Color.WHITE);
                gc.strokeOval(10 + bulletsXPosition, y2PositionofAlienSpaceship + 20 + bulletsYPosition, 3, 7);
                gc.fillOval(10 + bulletsXPosition, y2PositionofAlienSpaceship + 20 + bulletsYPosition, 3, 7);
            }
        }

        int houseX1Position = 0, houseX2Position = 0;

        //***draws a row of the houses.
        for (int k = 0; k < 10; k++) {
            houseX1Position = 30 + k * 60;
            houseX2Position = 25 + k * 60;
            gc.setFill(Color.YELLOW);
            gc.fillRect(houseX1Position, 570, 20, 15);
            gc.setFill(Color.BLUE);
            gc.fillRect(houseX2Position, 565, 30, 5);
        }

        //***set the color of player's spaceship using user input.
        gc.setStroke(Color.WHITE);
        gc.setFill(Color.rgb(red, green, blue));

        //***draws and place the player's spaceship at fixed y position and x position given by the user. 
        gc.strokeRect(xPositionPlayerSpaceship + 14, 615, 3, 5);
        gc.strokeOval(xPositionPlayerSpaceship + 5, 620, 20, 10);
        gc.strokeRoundRect(xPositionPlayerSpaceship, 625, 30, 10, 10, 10);
        gc.fillRoundRect(xPositionPlayerSpaceship, 625, 30, 10, 10, 10);
        gc.fillOval(xPositionPlayerSpaceship + 5, 620, 20, 10);
        gc.fillRect(xPositionPlayerSpaceship + 14, 615, 3, 5);

    }

}
