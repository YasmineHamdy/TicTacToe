package FXML;

import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public abstract class storedGamesBase extends AnchorPane {

    protected final Button button;
    protected final ColorAdjust colorAdjust;
    protected final ImageView imageView;
    protected final Button button0;
    protected final ColorAdjust colorAdjust0;
    protected final Button button1;
    protected final ColorAdjust colorAdjust1;
    protected final Button button2;
    protected final ColorAdjust colorAdjust2;
    protected final Button button3;
    protected final ColorAdjust colorAdjust3;

    public storedGamesBase() {

        button = new Button();
        colorAdjust = new ColorAdjust();
        imageView = new ImageView();
        button0 = new Button();
        colorAdjust0 = new ColorAdjust();
        button1 = new Button();
        colorAdjust1 = new ColorAdjust();
        button2 = new Button();
        colorAdjust2 = new ColorAdjust();
        button3 = new Button();
        colorAdjust3 = new ColorAdjust();

        setId("AnchorPane");
        setPrefHeight(436.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");

        button.setLayoutX(120.0);
        button.setLayoutY(234.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(39.0);
        button.setPrefWidth(346.0);
        button.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305;");
        button.setText("VS Computer");

        colorAdjust.setBrightness(-0.2);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(0.31);
        colorAdjust.setSaturation(1.0);
        button.setEffect(colorAdjust);
        button.setFont(new Font("DejaVu Serif Italic", 25.0));

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(433.0);
        imageView.setLayoutX(84.0);
        imageView.setLayoutY(44.0);
        imageView.setOpacity(0.81);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("tttmarqlrg.gif").toExternalForm()));

        button0.setLayoutX(120.0);
        button0.setLayoutY(290.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(39.0);
        button0.setPrefWidth(346.0);
        button0.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305;");
        button0.setText("VS Local Player");

        colorAdjust0.setBrightness(-0.2);
        colorAdjust0.setContrast(1.0);
        colorAdjust0.setHue(0.31);
        colorAdjust0.setSaturation(1.0);
        button0.setEffect(colorAdjust0);
        button0.setFont(new Font("DejaVu Serif Italic", 25.0));

        button1.setLayoutX(120.0);
        button1.setLayoutY(347.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(39.0);
        button1.setPrefWidth(346.0);
        button1.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305;");
        button1.setText("VS Network Player");

        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(0.31);
        colorAdjust1.setSaturation(1.0);
        button1.setEffect(colorAdjust1);
        button1.setFont(new Font("DejaVu Serif Italic", 25.0));

        button2.setLayoutX(553.0);
        button2.setLayoutY(20.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(24.0);
        button2.setPrefWidth(26.0);
        button2.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305;");

        colorAdjust2.setBrightness(-0.2);
        colorAdjust2.setContrast(1.0);
        colorAdjust2.setHue(0.31);
        colorAdjust2.setSaturation(1.0);
        button2.setEffect(colorAdjust2);
        button2.setFont(new Font("DejaVu Serif Italic", 10.0));

     
        colorAdjust3.setBrightness(-0.2);
        colorAdjust3.setContrast(1.0);
        colorAdjust3.setHue(0.31);
        colorAdjust3.setSaturation(1.0);
        button3.setEffect(colorAdjust3);
        button3.setFont(new Font("DejaVu Serif Italic", 10.0));

        getChildren().add(button);
        getChildren().add(imageView);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);

    }
}
