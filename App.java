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
    private List<int[]> snake = new ArrayList<>();
    private int []food = new int[2];




    // Default moovement
    private int dirX = 1;
    private int dirY = 0;
      @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();







         Scene scene = new Scene(new StackPane(canvas), WIDTH, HEIGHT);

    





     primaryStage.setTitle("Snake Game - By Luke");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


       

    

    
}
