import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileReader;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
        // Grid settings
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;
    private static final int COLUMNS = WIDTH / TILE_SIZE;
    private static final int ROWS = HEIGHT / TILE_SIZE;



    // Game objects
    private List<int[]> snake = new ArrayList<>();// need to change
    private int []food = new int[2];
    // Logic
    private boolean gameOver = false;
    private Timeline timeline;
    private Random random = new Random();




    // Default moovement
    private int dirX = 1;
    private int dirY = 0;
      @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // Initialize snake (3 segments)
        snake.clear();
        snake.add(new int[]{10, 10});
        snake.add(new int[]{9, 10});
        snake.add(new int[]{8, 10});



        // Game loop
        timeline = new Timeline(new KeyFrame(Duration.millis(120), e -> {
            if (!gameOver) {
                update();
                draw(gc);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        Scene scene = new Scene(new StackPane(canvas), WIDTH, HEIGHT);
         // Input
        scene.setOnKeyPressed (event -> {
            KeyCode code = event.getCode();

            if (code == KeyCode.UP && dirY != 1) {
                dirX = 0; dirY = -1;
            } else if (code == KeyCode.DOWN && dirY != -1) {
                dirX = 0; dirY = 1;
            } else if (code == KeyCode.LEFT && dirX != 1) {
                dirX = -1; dirY = 0;
            } else if (code == KeyCode.RIGHT && dirX != -1) {
                dirX = 1; dirY = 0;
            } else if (code == KeyCode.SPACE && gameOver) {
                restart();
            }
        });

    
     

    





     primaryStage.setTitle("Snake Game - By Luke");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
    private void update() {
        // Move snake head
        int[] head = snake.get(0);
        int newX = head[0] + dirX;
        int newY = head[1] + dirY;

        // Check wall collision
        if (newX < 0 || newY < 0 || newX >= COLUMNS || newY >= ROWS) {
            gameOver = true;
            return;
        }

        // Check self collision
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(i)[0] == newX && snake.get(i)[1] == newY) {
                gameOver = true;
                return;
            }
        }

        // Add new head
        snake.add(0, new int[]{newX, newY});

        // Eat food
        if (newX == food[0] && newY == food[1]) {
            spawnFood(); 
        } else {
            snake.remove(snake.size() - 1); // normal movement
        }
    }

    private void draw(GraphicsContext gc) {
        // background
        gc.setFill(Color.web("#2c6ca8"));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        // food
        gc.setFill(Color.web("#d60000ff"));
        gc.fillOval(food[0] * TILE_SIZE, food[1] * TILE_SIZE, TILE_SIZE, TILE_SIZE);

        // snake
        gc.setFill(Color.web("#c45800ff"));
        for (int[] part : snake) {
            gc.fillRect(part[0] * TILE_SIZE, part[1] * TILE_SIZE, TILE_SIZE - 1, TILE_SIZE - 1);
        }

        if (gameOver) {
            gc.setFill(Color.web("#f5faffff"));
            gc.fillText("GAME OVER - press SPACE to restart", WIDTH / 2 - 100, HEIGHT / 2);


        }
        
    }

    private void spawnFood() {
        while (true) {
            int x = random.nextInt(COLUMNS);
            int y = random.nextInt(ROWS);
            boolean onSnake = false;

            for (int[] part : snake) {
                if (part[0] == x && part[1] == y) {
                    onSnake = true;
                    break;
                }
            }

            if (!onSnake) {
                food[0] = x;
                food[1] = y;
                return;
            }
        }
    }

    private void restart() {
        snake.clear();
        snake.add(new int[]{10, 10});
        snake.add(new int[]{9, 10});
        snake.add(new int[]{8, 10});
        dirX = 1;
        dirY = 0;
        gameOver = false;
        spawnFood();
    }




       

    

    
}
