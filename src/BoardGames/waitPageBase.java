package BoardGames;

import java.io.File;
import java.lang.*;
import java.util.*;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class waitPageBase extends AnchorPane {

    protected final Text text;
    protected final ImageView waitView;
    protected final Button exitButton;
    protected final Button backButton;
    protected final ColorAdjust colorAdjust;
    


    public waitPageBase() {

        text = new Text();
        waitView = new ImageView();
        exitButton = new Button();
        backButton = new Button();
        colorAdjust = new ColorAdjust();

        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");
        

        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(270.0);
        text.setLayoutY(143.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setText("Please wait...");
        text.setFont(new Font("DejaVu Sans Oblique", 36.0));
        colorAdjust.setBrightness(-0.2);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.02);
        colorAdjust.setSaturation(1.0);
        text.setEffect(colorAdjust);

        

        waitView.setFitHeight(250.0);
        waitView.setFitWidth(250.0);
        waitView.setLayoutX(270.0);
        waitView.setLayoutY(210.0);
        waitView.setPickOnBounds(true);
        File f2 = new File("./images/timer2.png");
        Image img2 = new Image(f2.toURI().toString());
        
        waitView.setImage(img2);
        waitView.setPickOnBounds(true); 
        
        

        exitButton.setLayoutX(698.0);
        exitButton.setLayoutY(14.0);
        exitButton.setMinWidth(34.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(22.0);
        exitButton.setPrefWidth(26.0);
        exitButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");

        exitButton.setEffect(colorAdjust);
        exitButton.setOnAction(event -> {
            Platform.exit();
        });
        
        backButton.setLayoutX(20.0);
        backButton.setLayoutY(520.0);
        backButton.setMinWidth(34.0);
        backButton.setMnemonicParsing(false);
        backButton.setText("Back");

        backButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");
        backButton.setEffect(colorAdjust);

        getChildren().add(text);
        getChildren().add(waitView);
        getChildren().add(exitButton);
        getChildren().add(backButton);

    }
}
