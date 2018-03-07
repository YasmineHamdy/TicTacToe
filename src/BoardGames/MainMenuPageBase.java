package BoardGames;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class MainMenuPageBase extends AnchorPane {

    protected final Button exitButton;
    protected final ColorAdjust colorAdjust;
    protected final Button tttButton;
    protected final ColorAdjust colorAdjust0;
    protected final Button salButton;
    protected final ColorAdjust colorAdjust1;
    protected final ImageView imageView;
    public MainMenuPageBase() {

        exitButton = new Button();
        colorAdjust = new ColorAdjust();
        tttButton = new Button();
        colorAdjust0 = new ColorAdjust();
        salButton = new Button();
        colorAdjust1 = new ColorAdjust();
        imageView = new ImageView();
        
        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");

        exitButton.setLayoutX(698.0);
        exitButton.setLayoutY(14.0);
        exitButton.setMinWidth(34.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(22.0);
        exitButton.setPrefWidth(26.0);
        exitButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");

        colorAdjust.setBrightness(-0.2);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.02);
        colorAdjust.setSaturation(1.0);
        exitButton.setEffect(colorAdjust);
        exitButton.setOnAction(event -> {
            Platform.exit();
        });

        tttButton.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        tttButton.setCache(true);
        tttButton.setLayoutX(172.0);
        tttButton.setLayoutY(294.0);
        tttButton.setMnemonicParsing(false);
        tttButton.setPrefHeight(54.0);
        tttButton.setPrefWidth(441.0);
        tttButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 30; -fx-padding: 10 20 10 20; -fx-font-size: 25; -fx-background-color: yellow;");
        tttButton.setText("Tic Tac Toe");
        tttButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        tttButton.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        tttButton.setFont(new Font("DejaVu Serif Italic", 24.0));
        

        colorAdjust0.setBrightness(-0.2);
        colorAdjust0.setContrast(1.0);
        colorAdjust0.setHue(-0.02);
        colorAdjust0.setSaturation(1.0);
        tttButton.setEffect(colorAdjust0);

        salButton.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        salButton.setCache(true);
        salButton.setLayoutX(172.0);
        salButton.setLayoutY(371.0);
        salButton.setMnemonicParsing(false);
        salButton.setPrefHeight(54.0);
        salButton.setPrefWidth(441.0);
        salButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 30; -fx-padding: 10 20 10 20; -fx-font-size: 25; -fx-background-color: yellow;");
        salButton.setText("Snake and Ladder");
        salButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        salButton.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        salButton.setFont(new Font("DejaVu Serif Italic", 24.0));

        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        salButton.setEffect(colorAdjust1);
        

        imageView.setFitHeight(230.0);
        imageView.setFitWidth(659.0);
        imageView.setLayoutX(56.0);
        imageView.setLayoutY(24.0);
        imageView.setPickOnBounds(true);
        
        
        
        File f = new File("./images/TGL_logo.png");
        Image img = new Image(f.toURI().toString());

        imageView.setImage(img);

        getChildren().add(exitButton);
        getChildren().add(tttButton);
        getChildren().add(salButton);
        getChildren().add(imageView);
    }
}
