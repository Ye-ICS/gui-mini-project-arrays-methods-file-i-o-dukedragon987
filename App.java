import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
import java.util.LinkedList;


public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    boolean fruitWasHit = false;
    int snakePos;
    
    @Override
    public void start(Stage stage) {
        FlowPane root = new FlowPane();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext snake = canvas.getGraphicsContext2D();
            snake.setFill(Color.BLUE);
    snake.fillRect(50, 50, 100, 100); // Draws a filled rectangle
    snake.setStroke(Color.RED);
    snake.setLineWidth(2);
    snake.strokeOval(200, 50, 80, 80); // Draws an outlined oval

     
        
        int snakeLength []= new int [87];

        if (fruitWasHit = true){
            

        }

        root.getChildren().addAll(canvas);
      
        
        

       

    //     switch (direction) {
    // case UP:    newHead = head.add(0, -1); break;
    // case DOWN:  newHead = head.add(0, 1); break;
    // case LEFT:  newHead = head.add(-1, 0); break;
    // case RIGHT: newHead = head.add(1, 0); break;
    //     }

      final Scene scene = new Scene(root, 1915,1024);
        stage.setScene(scene);
        stage.show();

    
}
}