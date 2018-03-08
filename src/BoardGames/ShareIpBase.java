package BoardGames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class ShareIpBase extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Button okButton;
    protected final Stage primaryStage;
    protected static String playerName="";
    protected static Text text;
    protected final ColorAdjust colorAdjust;
    protected final ColorAdjust colorAdjust0;
    protected final ColorAdjust colorAdjust1;
    protected final Button exitButton;
    ServerSocket server;
    
    
    public ShareIpBase(String ip,Stage primaryStage) {

        pane = new Pane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        okButton = new Button();
        this.primaryStage=primaryStage;
        text = new Text();
        colorAdjust = new ColorAdjust();
        colorAdjust0 = new ColorAdjust();
        colorAdjust1 = new ColorAdjust();
        exitButton = new Button();
        
        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");

        text.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        text.setLayoutX(100.0);
        text.setLayoutY(143.0);
        
        text.setText("Share this IP with your Openent");
        text.setFont(new Font("DejaVu Sans Oblique", 36.0));
        colorAdjust1.setBrightness(-0.2);
        colorAdjust1.setContrast(1.0);
        colorAdjust1.setHue(-0.02);
        colorAdjust1.setSaturation(1.0);
        text.setEffect(colorAdjust);

        

        label0.setLayoutX(160.0);
        label0.setLayoutY(58.0);
        label0.setPrefHeight(17.0);
        label0.setPrefWidth(128.0);
        label0.setText("Label");
        label0.setText(ip);
        
        label1.setLayoutX(21.0);
        label1.setLayoutY(70);
        label1.setPrefHeight(17.0);
        label1.setPrefWidth(314.0);
        label1.setText("Port");

        label2.setLayoutX(160.0);
        label2.setLayoutY(80);
        label2.setPrefHeight(17.0);
        label2.setPrefWidth(128.0);
      
        label0.setText(ip);
        
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
        okButton.setOnAction(e-> primaryStage.setScene(new Scene(new WaitingForConnectionBase())));
        
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


        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(label2);
        pane.getChildren().add(okButton);
        pane.getChildren().add(exitButton);
        pane.getChildren().add(text);
        getChildren().add(pane);
         InServer();
    }
     public void InServer()
    {
        try {
            this.server = new ServerSocket(0,1,InetAddress.getByName( InetAddress.getLocalHost().getHostAddress()));
           label2.setText(""+this.server.getLocalPort());
            new StartGame();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ShareIpBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ShareIpBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      class StartGame extends Thread
    {
        StartGame()  {
           start(); 
        }
        @Override
        public void run()
        {
            try {
                System.out.println("waiting connection");
               
                Socket s=server.accept();
                System.out.println("connection done");
                
                 NetworkPlayer intiatePlayer=new NetworkPlayer(0,true,playerName,s);
                 DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                 DataInputStream dis=new DataInputStream(s.getInputStream());
                 String name=dis.readUTF();
                 dos.writeUTF(intiatePlayer.name);

                 NetworkPlayer Player=new NetworkPlayer(1,false,name,s);
                Platform.runLater(()->primaryStage.setScene(new Scene(new TicTacToeGamePageBase(primaryStage,0,intiatePlayer,Player))));
            } catch (IOException ex) {
                Logger.getLogger(ShareIpBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }      
        
        
    }
      
}
