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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public  class ShareIpBase extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final Label label0;
     protected final Label label1;
    protected final Label label2;
    protected final Button button;
    protected final Stage primaryStage;
     protected static String playerName="";
    ServerSocket server;
    
    public ShareIpBase(String ip,Stage primaryStage) {

        pane = new Pane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        button = new Button();
        this.primaryStage=primaryStage;
        
        
        setId("AnchorPane");
        setPrefHeight(116.0);
        setPrefWidth(338.0);

        pane.setPrefHeight(116.0);
        pane.setPrefWidth(484.0);

        label.setLayoutX(21.0);
        label.setLayoutY(23.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(314.0);
        label.setText("Share this IP with your Openent");

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
        
        button.setLayoutX(409.0);
        button.setLayoutY(75.0);
        button.setMnemonicParsing(false);
        button.setText("ok");
        
        button.setOnAction(e-> primaryStage.setScene(new Scene(new WaitingForConnectionBase())));

        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(button);
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
