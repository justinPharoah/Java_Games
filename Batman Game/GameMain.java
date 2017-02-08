import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start (Stage primaryStage) throws Exception {

        //sets the Title for the game window
        primaryStage.setTitle("Batman: CS Edition");

        //GridPane contains the game's menu screen
        GridPane grid = new GridPane();

        //initializes MenuScreen object and adds it to the GridPane
        MenuScreen gameMenu = new MenuScreen();
        grid.getChildren().addAll(MenuScreen.imageBox, MenuScreen.hBox1, gameMenu);

        //initializes Group object and adds a canvas to it for the gaming screen
        Group root = new Group();
        Canvas canvas = new Canvas(1600, 900);
        root.getChildren().add(canvas);

        //adds 2D graphics to the canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(50, 50, 100, 200);

        //initializes a new scene and adds the grid containing the menu screen to it
        Scene scene = new Scene(grid, 800, 600);

        MenuScreen.batmanAudio.setCycleCount(100);
        MenuScreen.batmanAudio.cycleCountProperty();
        MenuScreen.batmanAudio.play();

        primaryStage.setScene(scene);
        primaryStage.show();

        //initializes a new scene and if playButton is pressed shows the canvas (gaming screen)
        Scene scene2 = new Scene(root);
        gameMenu.playButton.setOnMouseClicked(e -> {
            MenuScreen.batmanAudio.stop();
            primaryStage.setScene(scene2);
            primaryStage.show();
        });
    }
}
