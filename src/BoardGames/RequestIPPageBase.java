package BoardGames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RequestIPPageBase extends AnchorPane {

    protected final Text text;
     protected final Text text2;
    protected final Button okButton;
    protected final Button backButton;
    protected final Button exitButton;
    protected final TextField textField;
     protected final TextField textField2;
    protected final ColorAdjust colorAdjust;
    protected final ColorAdjust colorAdjust0;
    protected final ColorAdjust colorAdjust1;
    static String PName="";
    public RequestIPPageBase(Stage primaryStage) {

        text = new Text();
        text2 = new Text();
        okButton = new Button();
        backButton = new Button();
        exitButton = new Button();
        textField = new TextField();
        textField2 = new TextField();
        colorAdjust = new ColorAdjust();
        colorAdjust0 = new ColorAdjust();
        colorAdjust1 = new ColorAdjust();


        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");
        
        
        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(200.0);
        text.setLayoutY(143.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setText("please enter The IP");
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
        
        okButton.setOnAction((ActionEvent e)->
        {   
            try {
                //primaryStage.setScene(new Scene(new TicTacToeGamePageBase(1,null,textField.getText())));
                 Socket s=new Socket(textField.getText(),Integer.parseInt(textField2.getText()));
                 NetworkPlayer player=new NetworkPlayer(1,false,PName,s);  
                 DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                 DataInputStream dis=new DataInputStream(s.getInputStream());
                 dos.writeUTF(player.name);
                 String name=dis.readUTF();
                 NetworkPlayer player2=new NetworkPlayer(0,true,name,s);
                primaryStage.setScene(new Scene(new TicTacToeGamePageBase(primaryStage,1,player2,player)));
            } catch (IOException ex) {
                 Platform.runLater(()->{
                    Stage stage=new Stage();
                    IPErrorBase p=new IPErrorBase();
                  
                    stage.setScene(new Scene(p));
                    stage.show();
                 p.button.setOnAction(event -> {
                    stage.close();
                 });
                 });
            }
        }
        );
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
        textField.setLayoutY(180.0);
        textField.setStyle("-fx-background-color: black;fx-text-inner-color: yellow;");
        textField.setFont(new Font("System Italic", 22.0));
        
           
        text2.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text2.setLayoutX(200.0);
        text2.setLayoutY(270.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setText("please enter The Port");
        text2.setFont(new Font("DejaVu Sans Oblique", 36.0));
        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        text2.setEffect(colorAdjust);
        
        textField2.setLayoutX(230.0);
        textField2.setLayoutY(300.0);
        textField2.setStyle("-fx-background-color: black;fx-text-inner-color: yellow;");
        textField2.setFont(new Font("System Italic", 22.0));

        getChildren().add(text);
         getChildren().add(text2);
        getChildren().add(okButton);
        getChildren().add(backButton);
        getChildren().add(exitButton);
        getChildren().add(textField);
          getChildren().add(textField2);
    }
}
