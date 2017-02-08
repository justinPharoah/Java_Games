import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MenuScreen extends Parent {
    public static MenuButton playButton = new MenuButton("PLAY", 40, 250, 50);
    public ImageView image = new ImageView(new Image(getClass().getResourceAsStream("batman3.jpg")));
    public static HBox imageBox = new HBox();
    public static HBox hBox1 = new HBox(10);
    public static AudioClip batmanAudio = new AudioClip("file:Batman.mp3");


    public MenuScreen() {
        image.setFitWidth(800);
        image.setFitHeight(600);

        imageBox.getChildren().add(image);
        imageBox.setAlignment(Pos.CENTER);

        VBox menu1 = new VBox(10);
        VBox menu2 = new VBox(10);
        VBox menu3 = new VBox(10);
        VBox menu4 = new VBox(10);
        VBox menu5 = new VBox(10);
        VBox menu6 = new VBox(10);
        VBox menu8 = new VBox(10);

        HBox hBox2 = new HBox(10);

        HBox hBox3 = new HBox(10);
        HBox hBox4 = new HBox(10);
        HBox hBox5 = new HBox(10);
        HBox hBox6 = new HBox(10);
        HBox hBox7 = new HBox(10);

        menu1.setTranslateX(100);
        menu1.setTranslateY(200);

        menu2.setTranslateX(100);
        menu2.setTranslateY(200);

        menu3.setTranslateX(100);
        menu3.setTranslateY(200);

        menu5.setTranslateX(100);
        menu5.setTranslateY(200);

        menu6.setTranslateX(100);
        menu6.setTranslateY(200);

        menu8.setTranslateX(100);
        menu8.setTranslateY(200);

        final int OFFSET = 400;

        menu2.setTranslateX(OFFSET);

        Text text1 = new Text("Batman: CS Edition");
        text1.setFill(Color.WHITE);
        text1.setFont(Font.font(70));
        hBox1.getChildren().add(text1);
        hBox1.setAlignment(Pos.TOP_CENTER);

        //initializes store button
        //when store is clicked, screen goes to store menu
        MenuButton storeButton = new MenuButton("STORE", 20, 250, 30);
        storeButton.setOnMouseClicked(e -> {
            getChildren().add(menu2);

//            getChildren().remove(menu1);

            FadeTransition translate1 = new FadeTransition(Duration.millis(850), menu1);
            translate1.setFromValue(1.0);
            translate1.setToValue(0.0);

            FadeTransition translate = new FadeTransition(Duration.millis(1500), menu2);
            translate.setFromValue(0.0);
            translate.setToValue(1.0);

            translate1.play();

            translate.play();

            menu2.setTranslateX(100);
            menu2.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu1));

            text1.setText("STORE");
            getChildren().remove(menu1);
        });

        //initializes settings button
        //when settings is pressed, screen goes to settings menu
        MenuButton settingsButton = new MenuButton("SETTINGS", 20, 250, 30);
        settingsButton.setOnMouseClicked(e -> {
            getChildren().add(menu3);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu1);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu3);
            translate1.setFromValue(0.0);
            translate1.setToValue(1.0);

            translate.play();
            translate1.play();

            menu3.setTranslateX(100);
            menu3.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu1));

            text1.setText("SETTINGS");
            getChildren().remove(menu1);
        });

        //initializes about button
        MenuButton aboutButton = new MenuButton("ABOUT", 20, 250, 30);

        //initializes exit button
        MenuButton exitButton = new MenuButton("EXIT", 20, 250, 30);

        //initializes back button
        //when back button is pressed, screen changes to previously viewed menu
        MenuButton backButton = new MenuButton("\u2190 BACK", 20, 250, 30);
        backButton.setOnMouseClicked(e -> {
            getChildren().add(menu1);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu3);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu1);
            translate1.setFromValue(0.0);
            translate1.setToValue(1.0);

            translate.play();
            translate1.play();

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu3));

            text1.setText("Batman: CS Edition");
            getChildren().remove(menu3);
        });

        MenuButton backButton2 = new MenuButton("\u2190 BACK", 20, 250, 30);
        backButton2.setOnMouseClicked(e -> {
            getChildren().add(menu1);


            FadeTransition translate = new FadeTransition(Duration.millis(850), menu2);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu1);
            translate1.setFromValue(0.0);
            translate1.setToValue(1.0);

            translate.play();
            translate1.play();

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu2));

            text1.setText("Batman: CS Edition");
            getChildren().remove(menu2);
        });

        MenuButton backButton3 = new MenuButton("\u2190 BACK", 20, 250, 30);
        backButton3.setOnMouseClicked(e -> {
            getChildren().add(menu2);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu5);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu2);
            translate1.setFromValue(0.0);
            translate1.setToValue(1.0);

            translate.play();
            translate1.play();

            menu2.setTranslateX(100);
            menu2.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu5));

            text1.setText("STORE");
            getChildren().remove(menu5);
        });

        MenuButton backButton4 = new MenuButton("\u2190 BACK", 20, 250, 30);
        backButton4.setOnMouseClicked(e -> {
            getChildren().add(menu2);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu6);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu2);
            translate1.setFromValue(0.0);
            translate1.setToValue(1.0);

            translate.play();
            translate1.play();

            menu2.setTranslateX(100);
            menu2.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu6));

            text1.setText("STORE");
            getChildren().remove(menu6);

        });

        MenuButton backButton5 = new MenuButton("\u2190 BACK", 20, 250, 30);
        backButton5.setOnMouseClicked(e -> {
            getChildren().add(menu2);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu8);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu2);
            translate.setFromValue(0.0);
            translate.setToValue(1.0);

            translate.play();
            translate1.play();

            menu2.setTranslateX(100);
            menu2.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu8));

            text1.setText("STORE");
            getChildren().remove(menu8);
        });

        MenuButton backButton6 = new MenuButton("\u2190 BACK", 20, 250, 30);


        //initializes and customizes sound button
        RadioButton sound = new RadioButton("SOUND OFF");
        sound.setTextFill(Color.WHITE);
        sound.setFont(Font.font(15));

        //initializes and customizes music button
        RadioButton music = new RadioButton("MUSIC OFF");
        music.setTextFill(Color.WHITE);
        music.setFont(Font.font(15));
        music.setOnMouseClicked(e -> {
            batmanAudio.stop();
        });

        //initializes weapons button
        //when weapons button is pressed, the screen for weapons options is shown
        MenuButton weapons = new MenuButton("WEAPONS", 30, 200, 200);
        weapons.setAlignment(Pos.CENTER);
        weapons.setOnMouseClicked(e -> {
            getChildren().add(menu5);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu2);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu5);
            translate.setFromValue(0.0);
            translate.setToValue(1.0);

            translate.play();
            translate1.play();

            menu5.setTranslateX(100);
            menu5.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu2));

            text1.setText("WEAPONS");
//            getChildren().add(menu5);

            getChildren().remove(menu2);
        });

        MenuButton upgrades = new MenuButton("UPGRADES", 30, 200, 200);
        upgrades.setAlignment(Pos.CENTER);
        upgrades.setPadding(new Insets(5));
        upgrades.setOnMouseClicked(e -> {
            getChildren().add(menu6);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu2);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu6);
            translate.setFromValue(0.0);
            translate.setToValue(1.0);

            translate.play();
            translate1.play();

            menu6.setTranslateX(100);
            menu6.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu2));

            text1.setText("UPGRADES");
            getChildren().remove(menu2);
        });

        MenuButton utilities = new MenuButton("UTILITIES", 30, 200, 200);
        utilities.setAlignment(Pos.CENTER);
        utilities.setOnMouseClicked(e -> {
            getChildren().add(menu8);

            FadeTransition translate = new FadeTransition(Duration.millis(850), menu2);
            translate.setFromValue(1.0);
            translate.setToValue(0.0);

            FadeTransition translate1 = new FadeTransition(Duration.millis(1500), menu8);
            translate.setFromValue(0.0);
            translate.setToValue(1.0);

            translate.play();
            translate1.play();

            menu8.setTranslateX(100);
            menu8.setTranslateY(200);

//            translate.setOnFinished(event -> getChildren().remove(menu2));

            text1.setText("UTILITIES");
            getChildren().remove(menu2);
        });

        MenuButton stars = new MenuButton("Throwing Star", 20, 250, 30);

        MenuButton daggers = new MenuButton("Dagger", 20, 250, 30);

        MenuButton usps = new MenuButton("USP-S", 20, 250, 30);

        MenuButton kryptonite = new MenuButton("Kryptonite", 20, 250, 30);

        MenuButton brass = new MenuButton("Brass Knuckles", 20, 250, 30);

        MenuButton health = new MenuButton("Health", 20, 250, 30);

        MenuButton armor = new MenuButton("Armor", 20, 250, 30);

        MenuButton baseDamage = new MenuButton("Base Damage", 20, 250, 30);

        MenuButton weaponDamage = new MenuButton("Weapon Damage", 20, 250, 30);

        MenuButton speed = new MenuButton("Speed", 20, 250, 30);

        MenuButton hooks = new MenuButton("Grappling Hook", 20, 250, 30);

        hBox2.getChildren().addAll(weapons, upgrades, utilities);

        menu1.getChildren().addAll(playButton, storeButton, settingsButton, aboutButton);
        menu2.getChildren().addAll(hBox2, backButton2);
        menu3.getChildren().addAll(backButton, sound, music);
        menu5.getChildren().addAll(stars, daggers, usps, kryptonite, brass, backButton3);
        menu6.getChildren().addAll(health, armor, baseDamage, weaponDamage, speed, backButton4);
        menu8.getChildren().addAll(hooks, backButton5);

        Rectangle rectangle = new Rectangle(800, 600);
        rectangle.setFill(Color.GREY);
        rectangle.setOpacity(0.0);

        getChildren().addAll(rectangle, menu1);
    }
}
