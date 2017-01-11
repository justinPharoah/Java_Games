/**
 * Created by justinferrell on 12/31/16.
 */

//PROTOTYPE NOTICE: THIS IS AN EXPERIMENTAL AND UNFINISHED GAME OF TIC TAC TOE.
//FULLY FUNCTIONAL AND REFURBISHED GAME EXPERIENCE COMING SOON.

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.*;

public class TicTacToe extends Application {
    private boolean changeLetter = true;
    private boolean playable = true;
    private Cell[][] board = new Cell[3][3];
    private List<Combo> combos = new ArrayList<>();
    private Pane layout = new Pane();

    Scene scene1, scene2, scene3;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.onCloseRequestProperty().addListener(e -> primaryStage.close());
        primaryStage.setResizable(false);


        GridPane grid = new GridPane();
        VBox vBox1 = new VBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        Label label1 = new Label("Tic Tac Toe");
        Button playButton = new Button("Play 3x3");
        Button playButton2 = new Button("Play 6x6");

        label1.setFont(new Font("Times New Roman", 50));
        label1.setAlignment(Pos.TOP_CENTER);
        playButton.setMinWidth(300);
        playButton.setOnAction(e -> primaryStage.setScene(scene2));

        grid.setPadding(new Insets(10));

        hBox1.getChildren().add(playButton);
        hBox1.setAlignment(Pos.CENTER);

        hBox2.getChildren().add(playButton2);
        hBox2.setAlignment(Pos.BOTTOM_CENTER);

        vBox1.getChildren().addAll(hBox1, hBox2);
        vBox1.setAlignment(Pos.TOP_CENTER);

        grid.getChildren().addAll(vBox1);
        grid.setAlignment(Pos.CENTER);

        scene1 = new Scene(grid, 400, 400);
        
        BorderPane border2 = new BorderPane();

        layout.setPadding(new Insets(10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Cell tile = new Cell();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                layout.getChildren().add(tile);

                board[j][i] = tile;
            }
        }

        //horizontal
        for(int y = 0; y < 3; y++) {
            combos.add(new Combo(board[0][y], board[1][y], board[2][y]));
        }

        //vertical
        for(int x = 0; x < 3; x++) {
            combos.add(new Combo(board[x][0], board[x][1], board[x][2]));
        }

        //diagonals
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));


        border2.getChildren().add(layout);
        scene2 = new Scene(border2, 600, 700);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private class Cell extends StackPane {
        private Text text = new Text();

        private Cell() {
            Rectangle rec = new Rectangle(200, 200);
            rec.setFill(null);
            rec.setStroke(Color.BLACK);

            text.setFont(Font.font(72));

            setAlignment(Pos.CENTER);
            getChildren().addAll(rec, text);

            setOnMouseClicked(event -> {
                if(!playable)
                    return;

                if (event.getButton() == MouseButton.PRIMARY) {
                    if(!changeLetter)
                        return;

                    xDraw();
                    changeLetter = false;
                    checkGame();
                } else if (event.getButton() == MouseButton.SECONDARY) {
                    if (changeLetter)
                        return;

                    oDraw();
                    changeLetter = true;
                    checkGame();
                }
            });
        }

        private double getCenterX() {
            return getTranslateX() + 100;
        }

        private double getCenterY() {
            return getTranslateY() + 100;
        }

        private String getValue() {
            return text.getText();
        }

        private void xDraw() {
            text.setText("X");
            text.setStroke(Color.web("00FFFF"));
            text.setFill(Color.web("00FFFF"));
        }

        private void oDraw() {
            text.setText("O");
            text.setStroke(Color.web("#C0C0C0"));
            text.setFill(Color.web("#C0C0C0"));
        }
    }

    private class Combo {
        private Cell[] tiles;
        private Combo(Cell... tiles) {
            this.tiles = tiles;
        }

        private boolean isComplete() {
            return !tiles[0].getValue().isEmpty() && tiles[0].getValue().equals(tiles[1].getValue())
                    && tiles[0].getValue().equals(tiles[2].getValue());
        }
    }

    private void winAnimation(Combo combo) {
        Line line = new Line();
        line.setStrokeWidth(10);
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());
        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());

        layout.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.5),
                new KeyValue(line.endXProperty(), combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.tiles[2].getCenterY())));
        timeline.play();
    }
    
    private void checkGame() {
        for(Combo combo : combos) {
            if(combo.isComplete()) {
                playable = false;
                winAnimation(combo);
                break;
            }
        }
    }
}
