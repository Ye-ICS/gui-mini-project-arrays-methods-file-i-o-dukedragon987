import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Point2D;
import java.util.LinkedList;


public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        FlowPane root = new FlowPane();
        Canvas canvas = new Canvas(500, 500);
        
        int snakeLength []= new int [87];
        

       

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