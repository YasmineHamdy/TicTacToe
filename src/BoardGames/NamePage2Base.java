package BoardGames;

import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class NamePage2Base extends AnchorPane {

    protected final Text text;
    protected final Button okButton;
    protected final Button backButton;
    protected final Button exitButton;
    protected final TextField textField;
    protected final ColorAdjust colorAdjust;
    protected final ColorAdjust colorAdjust0;
    protected final ColorAdjust colorAdjust1;

    public NamePage2Base() {

        text = new Text();
        okButton = new Button();
        backButton = new Button();
        exitButton = new Button();
        textField = new TextField();
        colorAdjust = new ColorAdjust();
        colorAdjust0 = new ColorAdjust();
        colorAdjust1 = new ColorAdjust();


        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");
        
        
        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(120.0);
        text.setLayoutY(143.0);
        text.setText("please enter player 2 name");
        text.setWrappingWidth(500.3671875);
        text.setFont(new Font("DejaVu Sans Oblique", 36.0));
        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        text.setEffect(colorAdjust);
        
        
        backButton.setLayoutX(20.0);
        backButton.setLayoutY(332.0);
        backButton.setMinWidth(34.0);
        backButton.setMnemonicParsing(false);
        backButton.setText("Back");

        backButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");

        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        backButton.setEffect(colorAdjust1);
        

        okButton.setLayoutX(40.0);
        okButton.setLayoutY(332.0);
        okButton.setMnemonicParsing(false);
        okButton.setText("Ok");
        
        okButton.setLayoutX(688.0);
        okButton.setLayoutY(332.0);
        okButton.setMinWidth(34.0);
        okButton.setMnemonicParsing(false);
        
        okButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");

        colorAdjust0.setBrightness(-0.2);
        colorAdjust0.setContrast(1.0);
        colorAdjust0.setHue(-0.02);
        colorAdjust0.setSaturation(1.0);
        okButton.setEffect(colorAdjust0);
        
        
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

        textField.setLayoutX(230.0);
        textField.setLayoutY(200.0);
        textField.setStyle("-fx-background-color: black; -fx-text-fill: yellow; -fx-font-size: 16;");
        textField.setFont(new Font("System Italic", 22.0));

        getChildren().add(text);
        getChildren().add(okButton);
        getChildren().add(backButton);
        getChildren().add(exitButton);
        getChildren().add(textField);

    }
}
