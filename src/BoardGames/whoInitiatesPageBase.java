package BoardGames;

import java.io.File;
import BoardGames.TicTacToeGamePageBase;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class whoInitiatesPageBase extends AnchorPane {

    protected final Text text;
    protected final Text youText;
    protected final Text oppText;

    protected final Button exitButton;
    protected final Button backButton;
    protected final ColorAdjust colorAdjust;
    protected final ImageView you;
    protected final ImageView opponent;
    static String name="";

    public whoInitiatesPageBase(Stage primaryStage) {

        text = new Text();
        youText = new Text();
        oppText = new Text();
        exitButton = new Button();
        backButton = new Button();
        you = new ImageView();
        opponent = new ImageView();
        colorAdjust = new ColorAdjust();
       

        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");
        
        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(150.0);
        text.setLayoutY(143.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setText("Who will initiate the game?");
        text.setFont(new Font("DejaVu Sans Oblique", 36.0));
        colorAdjust.setBrightness(-0.2);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.02);
        colorAdjust.setSaturation(1.0);
        text.setEffect(colorAdjust);

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
        
        you.setFitHeight(107.0);
        you.setFitWidth(133.0);
        you.setLayoutX(100.0);
        you.setLayoutY(300.0);
        you.setPickOnBounds(true);
        File f3 = new File("./images/opponent.PNG");
        Image img3 = new Image("https://www.mariowiki.com/images/thumb/6/6b/BMarioSluggers.PNG/215px-BMarioSluggers.PNG");
        
        you.setImage(img3);
        you.setPickOnBounds(true);

        you.setOnMousePressed(e-> {
              try {
          ShareIpBase p = new ShareIpBase(InetAddress.getLocalHost().getHostAddress(),primaryStage);
            p.playerName=name;
               primaryStage.setScene(new Scene(p));
        } catch (UnknownHostException ex) {
            Logger.getLogger(whoInitiatesPageBase.class.getName()).log(Level.SEVERE, null, ex);
        }
             
           
        });
        opponent.setFitHeight(107.0);
        opponent.setFitWidth(133.0);
        opponent.setLayoutX(500.0);
        opponent.setLayoutY(300.0);
        opponent.setPickOnBounds(true);
          
        opponent.setOnMousePressed(e->       
        {
          RequestIPPageBase p=new RequestIPPageBase(primaryStage);
            p.PName=name;
            primaryStage.setScene(new Scene(p));
            
        });
        File f2 = new File("./images/opponent.PNG");
        Image img2 = new Image(f2.toURI().toString());
        
        opponent.setImage(img2);
        opponent.setPickOnBounds(true); 
        
        youText.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        youText.setLayoutX(140.0);
        youText.setLayoutY(460.0);
        youText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        youText.setStrokeWidth(0.0);
        youText.setText("You");
        youText.setWrappingWidth(462.3671875);
        youText.setFont(new Font("DejaVu Sans Oblique", 36.0));
        youText.setEffect(colorAdjust);
        
        oppText.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        oppText.setLayoutX(450.0);
        oppText.setLayoutY(460.0);
        oppText.setText("Opponent");
        oppText.setFont(new Font("DejaVu Sans Oblique", 36.0));
        oppText.setEffect(colorAdjust);
        
        getChildren().add(text);
        getChildren().add(youText);
        getChildren().add(oppText);
        getChildren().add(exitButton);
        getChildren().add(backButton);
        getChildren().add(opponent);
        getChildren().add(you);

    }
    
    

}
