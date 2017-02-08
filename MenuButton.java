import com.sun.prism.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

import java.awt.*;

//class for customized Buttons
public class MenuButton extends StackPane {
    private Text text;
//    public ImageView image = new ImageView(new Image(getClass().getResourceAsStream("button_play.png")));
//    Image image = new Image("buton_play.png");

    //constructor takes in the name for our customized buttons
    public MenuButton(String name, int font, int width, int height) {

        //sets and customizes the text for the buttons
        text = new Text(name);
        text.getFont();
        text.setFont(Font.font(font));
        text.setFill(Color.WHITE);

        //sets the shape and design of the buttons
        Rectangle rect = new Rectangle(width, height);
        rect.setOpacity(0.6);
        rect.setFill(Color.BLACK);
        rect.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER_LEFT);
        setRotate(-0.5);
        getChildren().addAll(rect, text);


        //various effects for the buttons when mouse hovers over them
        setOnMouseEntered(e -> {
            rect.setTranslateX(10);
            text.setTranslateX(10);
            rect.setFill(Color.WHITE);
            text.setFill(Color.BLACK);
        });

        setOnMouseEntered(e -> {
            rect.setTranslateX(0);
            text.setTranslateX(0);
            rect.setFill(Color.BLACK);
            text.setFill(Color.WHITE);
        });

        DropShadow drop = new DropShadow(50, Color.WHITE);
        drop.setInput(new Glow());

        setOnMousePressed(event -> setEffect(drop));
        setOnMouseReleased(event -> setEffect(null));

    }
//    public void draw(GraphicsContext gc) {
//        gc.drawImage(image, 100, 200);
//    }
}
