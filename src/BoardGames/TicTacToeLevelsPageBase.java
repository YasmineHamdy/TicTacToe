package BoardGames;

import java.io.File;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TicTacToeLevelsPageBase extends AnchorPane {

    protected final Text text;
    protected final ImageView level1;
    protected final ImageView level2;
    protected final ImageView level3;
    protected final Button exitButton;
    protected final Button backButton;
    protected final ColorAdjust colorAdjust;
    


    public TicTacToeLevelsPageBase() {

        text = new Text();
        level1 = new ImageView();
        level2 = new ImageView();
        level3 = new ImageView();
        exitButton = new Button();
        backButton = new Button();
        colorAdjust = new ColorAdjust();

        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");
        

        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(300.0);
        text.setLayoutY(143.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setText("Levels");
        text.setFont(new Font("DejaVu Sans Oblique", 36.0));
        colorAdjust.setBrightness(-0.2);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.02);
        colorAdjust.setSaturation(1.0);
        text.setEffect(colorAdjust);

        level1.setFitHeight(107.0);
        level1.setFitWidth(133.0);
        level1.setLayoutX(100.0);
        level1.setLayoutY(300.0);
        level1.setPickOnBounds(true);
        File f3 = new File("./images/level1.png");
        Image img3 = new Image(f3.toURI().toString());
        
        level1.setImage(img3);
        level1.setPickOnBounds(true); 
        

        level2.setFitHeight(107.0);
        level2.setFitWidth(133.0);
        level2.setLayoutX(300.0);
        level2.setLayoutY(300.0);
        level2.setPickOnBounds(true);
        File f2 = new File("./images/level2.png");
        Image img2 = new Image(f2.toURI().toString());
        
        level2.setImage(img2);
        level2.setPickOnBounds(true); 
        
        
        level3.setFitHeight(107.0);
        level3.setFitWidth(133.0);
        level3.setLayoutX(500.0);
        level3.setLayoutY(300.0);
        level3.setPickOnBounds(true);
        File f = new File("./images/level3.png");
        Image img = new Image(f.toURI().toString());

        level3.setImage(img);
        level3.setPickOnBounds(true); 
        

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
        getChildren().add(level1);
        getChildren().add(level2);
        getChildren().add(level3);
        getChildren().add(exitButton);
        getChildren().add(backButton);

    }
}
