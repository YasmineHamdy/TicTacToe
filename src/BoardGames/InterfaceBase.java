package BoardGames;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class InterfaceBase extends AnchorPane {

    protected final ImageView imageView;
    protected final DropShadow dropShadow;
    protected final Button button;
    protected final Lighting lighting;
    protected final Button button0;
    protected final ColorAdjust colorAdjust;
    protected final Button button1;
    protected final Lighting lighting0;

    public InterfaceBase() {

        imageView = new ImageView();
        dropShadow = new DropShadow();
        button = new Button();
        lighting = new Lighting();
        button0 = new Button();
        colorAdjust = new ColorAdjust();
        button1 = new Button();
        lighting0 = new Lighting();

        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");

        imageView.setFitHeight(197.0);
        imageView.setFitWidth(615.0);
        imageView.setLayoutX(55.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setSmooth(false);
        imageView.setImage(new Image(getClass().getResource("../../../../Desktop/TGL_logo.png").toExternalForm()));

        imageView.setEffect(dropShadow);

        button.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        button.setCache(true);
        button.setLayoutX(162.0);
        button.setLayoutY(280.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(54.0);
        button.setPrefWidth(401.0);
        button.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 30; -fx-padding: 10 20 10 20;");
        button.setText("Tic Tac Toe");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        button.setFont(new Font("DejaVu Serif Italic", 24.0));

        button.setEffect(lighting);
        button.setCursor(Cursor.HAND);

        button0.setLayoutX(719.0);
        button0.setLayoutY(14.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(0.0);
        button0.setPrefWidth(31.0);
        button0.setStyle("-fx-background-radius: 500; -fx-background-color: purple;");
        button0.setCursor(Cursor.HAND);

        colorAdjust.setBrightness(0.44);
        button0.setEffect(colorAdjust);

        button1.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        button1.setCache(true);
        button1.setLayoutX(162.0);
        button1.setLayoutY(367.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(54.0);
        button1.setPrefWidth(401.0);
        button1.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 30; -fx-padding: 10 20 10 20;");
        button1.setText("snake and Ladder");
        button1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button1.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        button1.setFont(new Font("DejaVu Serif Italic", 24.0));

        button1.setEffect(lighting0);
        button1.setCursor(Cursor.HAND);

        getChildren().add(imageView);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);

    }
}
