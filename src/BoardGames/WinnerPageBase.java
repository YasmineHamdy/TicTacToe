package BoardGames;

import java.io.File;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WinnerPageBase extends AnchorPane {

    protected final Button exitButton;
    protected final Button playAgainButton;
    protected final Button replayButton;
    protected final ColorAdjust colorAdjust;
    protected final ColorAdjust colorAdjust0;
    protected final ColorAdjust colorAdjust1;
    protected final ImageView imageView;
    protected final Text text;

    public WinnerPageBase() {

        exitButton = new Button();
        playAgainButton = new Button();
        replayButton = new Button();
        colorAdjust = new ColorAdjust();
        colorAdjust0 = new ColorAdjust();
        colorAdjust1 = new ColorAdjust();
        imageView = new ImageView();
        text = new Text();

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

        playAgainButton.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        playAgainButton.setCache(true);
        playAgainButton.setLayoutX(172.0);
        playAgainButton.setLayoutY(294.0);
        playAgainButton.setMnemonicParsing(false);
        playAgainButton.setPrefHeight(54.0);
        playAgainButton.setPrefWidth(441.0);
        playAgainButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 30; -fx-padding: 10 20 10 20; -fx-font-size: 25; -fx-background-color: yellow;");
        playAgainButton.setText("Play again");
        playAgainButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playAgainButton.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        playAgainButton.setFont(new Font("DejaVu Serif Italic", 24.0));

        colorAdjust0.setBrightness(-0.2);
        colorAdjust0.setContrast(1.0);
        colorAdjust0.setHue(-0.02);
        colorAdjust0.setSaturation(1.0);
        playAgainButton.setEffect(colorAdjust0);

        
        replayButton.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        replayButton.setCache(true);
        replayButton.setLayoutX(172.0);
        replayButton.setLayoutY(371.0);
        replayButton.setMnemonicParsing(false);
        replayButton.setPrefHeight(54.0);
        replayButton.setPrefWidth(441.0);
        replayButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 30; -fx-padding: 10 20 10 20; -fx-font-size: 25; -fx-background-color: yellow;");
        replayButton.setText("Replay");
        replayButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        replayButton.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        replayButton.setFont(new Font("DejaVu Serif Italic", 24.0));

        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        replayButton.setEffect(colorAdjust1);

        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(190.0);
        text.setLayoutY(143.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setFont(new Font("DejaVu Sans Oblique", 40.0));
        text.setStyle("-fx-font-weight: bold");
        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        text.setEffect(colorAdjust);

        getChildren().add(exitButton);
        getChildren().add(playAgainButton);
        getChildren().add(replayButton);
        getChildren().add(text);

    }
}
