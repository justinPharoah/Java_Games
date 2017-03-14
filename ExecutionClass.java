/**
 * Created by justinferrell on 12/16/16.
 */
/*
This program runs a simple Sonic-Themed Menu Screen. It features basic buttons, 
a Sonic background, and the Sonic theme song when run.
*/

import com.sun.tools.javadoc.Start;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import java.net.URL;

public class ExecutionClass extends Application {
    private GameMenu gameMenu;
    private static final String MEDIA_URL = "https://youtu.be/UEannNh8ihA";
    private static AudioClip audio = new AudioClip("file:Sonic.mp3");


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Sonic: Computer Science Edition");
        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("Sonic-the-Hedgehog-800-600.jpg")));
//        ImageView image = new ImageView(new Image(getClass().getResourceAsStream("sonic.png")));

        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10));

        HBox hBox = new HBox();
        hBox.getChildren().add(image);
        hBox.setAlignment(Pos.CENTER);

        gameMenu = new GameMenu();
        gameMenu.setVisible(false);

        grid.getChildren().addAll(hBox, gameMenu);

        Scene scene = new Scene(grid,800, 600);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                if (!gameMenu.isVisible()) {
                    FadeTransition fade = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    fade.setFromValue(0);
                    fade.setToValue(1);

                    gameMenu.setVisible(true);
                    fade.play();
                } else {
                    FadeTransition fade = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    fade.setFromValue(1);
                    fade.setToValue(0);
                    fade.setOnFinished(event1 -> gameMenu.setVisible(false));
                    fade.play();
                }
            }
        });
        audio.play();

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private class GameMenu extends Parent {
        private GameMenu() {
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);

            menu0.setTranslateX(100);
            menu0.setTranslateY(200);

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            final int OFFSET = 400;

            menu1.setTranslateX(OFFSET);

            MenuButton resumeButton = new MenuButton(" RESUME");
            resumeButton.setOnMouseClicked(event -> {
                FadeTransition fade = new FadeTransition(Duration.seconds(0.5), this);
                fade.setFromValue(1);
                fade.setToValue(0);
                fade.setOnFinished(event1 -> setVisible(false));
                fade.play();
            });

            MenuButton optionButton = new MenuButton(" OPTIONS");
            optionButton.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition translate = new TranslateTransition(Duration.seconds(0.25), menu0);
                translate.setToX(menu0.getTranslateX() - OFFSET);

                TranslateTransition translate1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                translate1.setToX(menu0.getTranslateX());

                translate.play();
                translate1.play();

                translate.setOnFinished(event1 -> getChildren().remove(menu0));
            });

            MenuButton exitButton = new MenuButton(" EXIT");
            exitButton.setOnMouseClicked(event -> System.exit(0));

            MenuButton backButton = new MenuButton(" <- BACK");
            backButton.setOnMouseClicked(event -> {

                getChildren().add(menu0);

                TranslateTransition translate = new TranslateTransition(Duration.seconds(0.25), menu1);
                translate.setToX(menu1.getTranslateX() + OFFSET);

                TranslateTransition translate1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                translate1.setToX(menu1.getTranslateX());

                translate.play();
                translate1.play();

                translate.setOnFinished(event1 -> getChildren().remove(menu1));
            });

            MenuButton soundButton = new MenuButton(" SOUND");
            MenuButton videoButton = new MenuButton(" VIDEO");

            menu0.getChildren().addAll(resumeButton, optionButton, exitButton);
            menu1.getChildren().addAll(backButton, soundButton, videoButton);

            Rectangle rectangle = new Rectangle(800, 600);
            rectangle.setFill(Color.BLUE);
            rectangle.setOpacity(0.4);

            getChildren().addAll(rectangle, menu0);
        }
    }

    private static class MenuButton extends StackPane {
        private Text text;

        private MenuButton(String name) {
            text = new Text(name);
            text.getFont();
            text.setFont(Font.font(20));
            text.setFill(Color.WHITE);

            Rectangle rec = new Rectangle(250, 30);
            rec.setOpacity(0.6);
            rec.setFill(Color.BLACK);
            rec.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(rec, text);

            setOnMouseEntered(event -> {
                rec.setTranslateX(10);
                text.setTranslateX(10);
                rec.setFill(Color.WHITE);
                text.setFill(Color.BLACK);
            });

            setOnMouseEntered(event -> {
                rec.setTranslateX(0);
                text.setTranslateX(0);
                rec.setFill(Color.BLACK);
                text.setFill(Color.WHITE);

            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
}
