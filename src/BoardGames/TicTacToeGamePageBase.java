package BoardGames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToeGamePageBase extends AnchorPane {

    protected final Button exitButton;
    protected final Button backButton;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label cell0;
    protected final Label cell1;
    protected final Label cell2;
    protected final Label cell3;
    protected final Label cell4;
    protected final Label cell5;
    protected final Label cell6;
    protected final Label cell7;
    protected final Label cell8;
    protected final Separator separator;
    protected final ColorAdjust colorAdjust;
    protected final ColorAdjust colorAdjust2;
    protected final Text vsText;
    protected final ColorAdjust colorAdjust0;
    protected final Text player1Text;
    protected final Text player2Text;
    protected final ColorAdjust colorAdjust1;

    protected final ImageView imagecell0ViewO;
    protected final ImageView imagecell0ViewX;
    protected final ImageView imagecell1ViewO;
    protected final ImageView imagecell1ViewX;
    protected final ImageView imagecell2ViewO;
    protected final ImageView imagecell2ViewX;
    protected final ImageView imagecell3ViewO;
    protected final ImageView imagecell3ViewX;
    protected final ImageView imagecell4ViewO;
    protected final ImageView imagecell4ViewX;
    protected final ImageView imagecell5ViewO;
    protected final ImageView imagecell5ViewX;
    protected final ImageView imagecell6ViewO;
    protected final ImageView imagecell6ViewX;
    protected final ImageView imagecell7ViewO;
    protected final ImageView imagecell7ViewX;
    protected final ImageView imagecell8ViewO;
    protected final ImageView imagecell8ViewX;
    protected final Label label8;

    double xOffset = 0;
    double yOffset = 0;
    ServerSocket server;
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    String ip;
    int mode;
    NetworkPlayer  p;
    NetworkPlayer  p2;
    TicTacToe2 startGame;
    StartGame sg;

    public static int pos = -1;
    public static boolean enabled = true;
    public static boolean firstTurn = false;
    public static boolean secondtTurn = false;

    public TicTacToeGamePageBase(Stage primaryStage,int mode,PlayerInterface player,PlayerInterface player2) {

        label8 = new Label();
        exitButton = new Button();
        backButton = new Button();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        cell0 = new Label();
        cell1 = new Label();
        cell2 = new Label();
        cell3 = new Label();
        cell4 = new Label();
        cell5 = new Label();
        cell6 = new Label();
        cell7 = new Label();
        cell8 = new Label();
        separator = new Separator();
        colorAdjust = new ColorAdjust();
        vsText = new Text();
        colorAdjust0 = new ColorAdjust();
        player1Text = new Text();
        player2Text = new Text();
        colorAdjust1 = new ColorAdjust();
        colorAdjust2 = new ColorAdjust();

        imagecell0ViewX = new ImageView();
        imagecell0ViewO = new ImageView();
        imagecell1ViewX = new ImageView();
        imagecell1ViewO = new ImageView();
        imagecell2ViewX = new ImageView();
        imagecell2ViewO = new ImageView();
        imagecell3ViewX = new ImageView();
        imagecell3ViewO = new ImageView();
        imagecell4ViewX = new ImageView();
        imagecell4ViewO = new ImageView();
        imagecell5ViewX = new ImageView();
        imagecell5ViewO = new ImageView();
        imagecell6ViewX = new ImageView();
        imagecell6ViewO = new ImageView();
        imagecell7ViewX = new ImageView();
        imagecell7ViewO = new ImageView();
        imagecell8ViewX = new ImageView();
        imagecell8ViewO = new ImageView();

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
            if(mode==0)
            {
                try {
                    dis.close();
                    dos.close();
                    this.p.socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else if(mode==1)
            {
                  try {
                    dis.close();
                    dos.close();
                    this.p2.socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Platform.exit();
        });

        backButton.setLayoutX(20.0);
        backButton.setLayoutY(520.0);
        backButton.setMinWidth(34.0);
        backButton.setMnemonicParsing(false);
        backButton.setText("Back");

        backButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");
        backButton.setEffect(colorAdjust);

        gridPane.setGridLinesVisible(true);
        gridPane.setLayoutX(127.0);
        gridPane.setLayoutY(158.0);
        gridPane.setPrefHeight(266.0);
        gridPane.setPrefWidth(485.0);
        gridPane.setStyle("-fx-background-color: yellow;");



        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(235.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(160.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(349.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(168.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(349.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(160.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        gridPane.setCursor(Cursor.HAND);



        File fo = new File("./images/o.png");
        Image imgo = new Image(fo.toURI().toString());
        File fx = new File("./images/x.png");
        Image imgx = new Image("http://icons.iconarchive.com/icons/double-j-design/origami-colored-pencil/128/blue-cross-icon.png");
        imagecell0ViewX.setFitHeight(80.0);
        imagecell0ViewX.setFitWidth(140.0);
        imagecell0ViewX.setImage(imgx);

        imagecell0ViewO.setFitHeight(80.0);
        imagecell0ViewO.setFitWidth(140.0);
        imagecell0ViewO.setImage(imgo);

        imagecell1ViewX.setFitHeight(80.0);
        imagecell1ViewX.setFitWidth(140.0);
        imagecell1ViewX.setImage(imgx);

        imagecell1ViewO.setFitHeight(80.0);
        imagecell1ViewO.setFitWidth(140.0);
        imagecell1ViewO.setImage(imgo);

        imagecell2ViewX.setFitHeight(80.0);
        imagecell2ViewX.setFitWidth(140.0);
        imagecell2ViewX.setImage(imgx);

        imagecell2ViewO.setFitHeight(80.0);
        imagecell2ViewO.setFitWidth(140.0);
        imagecell2ViewO.setImage(imgo);

        imagecell3ViewX.setFitHeight(80.0);
        imagecell3ViewX.setFitWidth(140.0);
        imagecell3ViewX.setImage(imgx);

        imagecell3ViewO.setFitHeight(80.0);
        imagecell3ViewO.setFitWidth(140.0);
        imagecell3ViewO.setImage(imgo);

        imagecell4ViewX.setFitHeight(80.0);
        imagecell4ViewX.setFitWidth(140.0);
        imagecell4ViewX.setImage(imgx);

        imagecell4ViewO.setFitHeight(80.0);
        imagecell4ViewO.setFitWidth(140.0);
        imagecell4ViewO.setImage(imgo);

        imagecell5ViewX.setFitHeight(80.0);
        imagecell5ViewX.setFitWidth(140.0);
        imagecell5ViewX.setImage(imgx);

        imagecell5ViewO.setFitHeight(80.0);
        imagecell5ViewO.setFitWidth(140.0);
        imagecell5ViewO.setImage(imgo);

        imagecell6ViewX.setFitHeight(80.0);
        imagecell6ViewX.setFitWidth(140.0);
        imagecell6ViewX.setImage(imgx);

        imagecell6ViewO.setFitHeight(80.0);
        imagecell6ViewO.setFitWidth(140.0);
        imagecell6ViewO.setImage(imgo);

        imagecell7ViewX.setFitHeight(80.0);
        imagecell7ViewX.setFitWidth(140.0);
        imagecell7ViewX.setImage(imgx);

        imagecell7ViewO.setFitHeight(80.0);
        imagecell7ViewO.setFitWidth(140.0);
        imagecell7ViewO.setImage(imgo);

        imagecell8ViewX.setFitHeight(80.0);
        imagecell8ViewX.setFitWidth(140.0);
        imagecell8ViewX.setImage(imgx);

        imagecell8ViewO.setFitHeight(80.0);
        imagecell8ViewO.setFitWidth(140.0);
        imagecell8ViewO.setImage(imgo);

        GridPane.setColumnIndex(cell0, 0);
        GridPane.setRowIndex(cell0, 0);
        cell0.setPrefHeight(93.0);
        cell0.setPrefWidth(152.0);
        cell0.setId("cell0");
        cell0.applyCss();
        cell0.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(0)&& !this.startGame.GameEnded)){
                 cell0.setGraphic(imagecell0ViewX);
                 this.startGame.HoldPlace(0);
                try {
                     dos.writeInt(0);
                     dos.flush();
                       if(p.turn)
                                {
                                    startGame.player1.moves.add(0);
                                   if( startGame.CheckWinner(0))
                                   {
                                       this.startGame.Finish(0);
                                       System.out.println("winnner");
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(0);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                      p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(0)&& !this.startGame.GameEnded)
             {
                cell0.setGraphic(imagecell0ViewO);
                this.startGame.HoldPlace(0);
                   try {
                     dos.writeInt(0);
                     dos.flush();
                       if(p.turn)
                                {
                                    startGame.player1.moves.add(0);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(0);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=0;
                        Globals.pos=0;
                        Globals.enabled=false;
                }


             }

        });


        GridPane.setColumnIndex(cell3, 2);
        GridPane.setRowIndex(cell3, 0);
        cell3.setPrefHeight(93.0);
        cell3.setId("cell3");
        cell3.applyCss();
        cell3.setPrefWidth(152.0);
        cell3.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(3))&&!this.startGame.GameEnded){
                 cell3.setGraphic(imagecell3ViewX);
                 this.startGame.HoldPlace(3);
                try {
                     dos.writeInt(3);
                     dos.flush();
                       if(p.turn)
                                {
                                    startGame.player1.moves.add(3);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(3);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(3)&&!this.startGame.GameEnded)
             {
                cell3.setGraphic(imagecell3ViewO);
                this.startGame.HoldPlace(3);
                   try {
                     dos.writeInt(3);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(3);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(3);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
               else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=3;
                        Globals.pos=3;
                        Globals.enabled=false;
                }


             }
        });


        GridPane.setColumnIndex(cell6, 1);
        GridPane.setRowIndex(cell6, 0);
        cell6.setPrefHeight(93.0);
        cell6.setId("cell6");
        cell6.applyCss();
        cell6.setPrefWidth(152.0);
        cell6.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(6)&&!this.startGame.GameEnded)){
                 cell6.setGraphic(imagecell6ViewX);
                 this.startGame.HoldPlace(6);
                try {
                     dos.writeInt(6);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(6);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(6);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }

                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;

                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(6)&&!this.startGame.GameEnded)
             {
                cell6.setGraphic(imagecell6ViewO);
                this.startGame.HoldPlace(6);
                   try {
                     dos.writeInt(6);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(6);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(6);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=6;
                        Globals.pos=6;
                        Globals.enabled=false;
                }


             }

        });

        GridPane.setColumnIndex(cell1, 0);
        GridPane.setRowIndex(cell1, 1);
        cell1.setPrefHeight(82.0);
        cell1.setId("cell1");
        cell1.applyCss();
        cell1.setPrefWidth(161.0);
        cell1.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(1)&&!this.startGame.GameEnded)){
                 cell1.setGraphic(imagecell1ViewX);
                 this.startGame.HoldPlace(1);
                try {
                     dos.writeInt(1);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(1);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(1);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(1)&&!this.startGame.GameEnded)
             {
                cell1.setGraphic(imagecell1ViewO);
                this.startGame.HoldPlace(1);
                   try {
                     dos.writeInt(1);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(1);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(1);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                    p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                else if(mode==2)
             {

                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=1;
                        Globals.pos=1;
                        Globals.enabled=false;
                }


             }
        });

        GridPane.setColumnIndex(cell4, 1);
        GridPane.setRowIndex(cell4, 1);
        cell4.setPrefHeight(93.0);
        cell4.setId("cell4");
        cell4.applyCss();
        cell4.setPrefWidth(152.0);
        cell4.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(4)&&!this.startGame.GameEnded)){

                 cell4.setGraphic(imagecell4ViewX);
                 this.startGame.HoldPlace(4);
                try {
                     dos.writeInt(4);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(4);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(4);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(4)&&!this.startGame.GameEnded)
             {
                cell4.setGraphic(imagecell4ViewO);
                this.startGame.HoldPlace(4);
                   try {
                     dos.writeInt(4);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(4);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(4);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                    p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=4;
                        Globals.pos=4;
                        Globals.enabled=false;
                }

             }
        });

        GridPane.setColumnIndex(cell7, 2);
        GridPane.setRowIndex(cell7, 1);
        cell7.setPrefHeight(93.0);
        cell7.setId("cell7");
        cell7.applyCss();
        cell7.setPrefWidth(152.0);
        cell7.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(7)&&!this.startGame.GameEnded)){
                 cell7.setGraphic(imagecell7ViewX);
                 this.startGame.HoldPlace(7);
                try {
                     dos.writeInt(7);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(7);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(7);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(7)&&!this.startGame.GameEnded)
             {
                cell7.setGraphic(imagecell7ViewO);
                this.startGame.HoldPlace(7);
                   try {
                     dos.writeInt(7);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(7);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(7);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                    p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                else if(mode==2)
             {
                 if(Globals.enabled){
                        TicTacToeGamePageBase.pos=7;
                        Globals.pos=7;
                        Globals.enabled=false;
                }


             }
        });

        GridPane.setColumnIndex(cell2, 0);
        GridPane.setRowIndex(cell2, 2);
        cell2.setPrefHeight(93.0);
        cell2.setId("cell2");
        cell2.applyCss();
        cell2.setPrefWidth(152.0);
        cell2.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(2)&&!this.startGame.GameEnded)){
                 cell2.setGraphic(imagecell2ViewX);
                 this.startGame.HoldPlace(2);
                try {
                     dos.writeInt(2);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(2);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(2);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                    p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(2)&&!this.startGame.GameEnded)
             {
                cell2.setGraphic(imagecell2ViewO);
                this.startGame.HoldPlace(2);
                   try {
                     dos.writeInt(2);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(2);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(2);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=2;
                        Globals.pos=2;
                        Globals.enabled=false;
                }


             }
        });

        GridPane.setColumnIndex(cell5, 1);
        GridPane.setRowIndex(cell5, 2);
        cell5.setPrefHeight(93.0);
        cell5.setId("cell5");
        cell5.applyCss();
        cell5.setPrefWidth(152.0);
        cell5.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
            if((mode==0 &&p.turn &&this.startGame.CheckPlace(5)&&!this.startGame.GameEnded)){
                 cell5.setGraphic(imagecell5ViewX);
                 this.startGame.HoldPlace(5);
                try {
                     dos.writeInt(5);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(5);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(5);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                    p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(5)&&!this.startGame.GameEnded)
             {
                cell5.setGraphic(imagecell5ViewO);
                this.startGame.HoldPlace(5);
                   try {
                     dos.writeInt(5);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(5);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(5);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
               else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=5;
                        Globals.pos=5;
                        Globals.enabled=false;
                }


             }
        });

        GridPane.setColumnIndex(cell8, 2);
        GridPane.setRowIndex(cell8, 2);
        cell8.setPrefHeight(90.0);
        cell8.setId("cell8");
        cell8.applyCss();
        cell8.setPrefWidth(152.0);
        cell8.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
             if((mode==0 &&p.turn &&this.startGame.CheckPlace(8)&&!this.startGame.GameEnded)){
                 cell8.setGraphic(imagecell8ViewX);
                 this.startGame.HoldPlace(8);
                try {
                     dos.writeInt(8);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(8);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(8);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                     p.turn=(p.turn)?false:true;
                     p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
             else if( mode==1 &&p2.turn &&this.startGame.CheckPlace(8)&&!this.startGame.GameEnded)
             {
                cell8.setGraphic(imagecell8ViewO);
                this.startGame.HoldPlace(8);
                   try {
                     dos.writeInt(8);
                     dos.flush();
                      if(p.turn)
                                {
                                    startGame.player1.moves.add(8);
                                     if( startGame.CheckWinner(0))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(0);
                                       sg.stop();
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(8);
                                     if( startGame.CheckWinner(1))
                                   {
                                       System.out.println("winnner");
                                       this.startGame.Finish(1);
                                       sg.stop();
                                   }
                                }
                    p.turn=(p.turn)?false:true;
                      p2.turn=(p2.turn)?false:true;
                 } catch (IOException ex) {
                     Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                else if(mode==2)
             {
                if(Globals.enabled){
                        TicTacToeGamePageBase.pos=8;
                        Globals.pos=8;
                        Globals.enabled=false;
                }


             }
        });

        //65,41
        separator.setLayoutX(120.0);
        separator.setLayoutY(120.0);
        separator.setPrefHeight(0.0);
        separator.setPrefWidth(485.0);
        separator.setStyle("-fx-background-radius: 25;");

        colorAdjust2.setBrightness(-0.2);
        colorAdjust2.setContrast(1.0);
        colorAdjust2.setHue(0.32);
        colorAdjust2.setSaturation(1.0);
        separator.setEffect(colorAdjust2);

        vsText.setFill(javafx.scene.paint.Color.valueOf("yellow"));
        vsText.setLayoutX(342.0);
        vsText.setLayoutY(100.0);
        vsText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        vsText.setStrokeWidth(0.0);
        vsText.setText("VS");
        vsText.setFont(new Font("DejaVu Serif Bold", 44.0));
        vsText.setEffect(colorAdjust);

        player1Text.setFill(javafx.scene.paint.Color.valueOf("#1d3cb8"));
        player1Text.setLayoutX(130.0);
        player1Text.setLayoutY(100.0);
        player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Text.setStrokeWidth(0.0);

        player1Text.setText("player1");
        player1Text.setFont(new Font("DejaVu Serif Bold", 23.0));

        player2Text.setFill(javafx.scene.paint.Color.valueOf("#f80707"));
        player2Text.setLayoutX(509.0);
        player2Text.setLayoutY(100.0);
        player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Text.setStrokeWidth(0.0);
        player2Text.setText("player2");
        player2Text.setFont(new Font("DejaVu Serif Bold", 23.0));



        label8.setLayoutX(265.0);
        label8.setLayoutY(89.0);
        label8.setPrefHeight(17.0);
        label8.setPrefWidth(64.0);

        setEffect(colorAdjust1);



        getChildren().add(exitButton);
        getChildren().add(backButton);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(cell0);
        gridPane.getChildren().add(cell1);
        gridPane.getChildren().add(cell2);
        gridPane.getChildren().add(cell3);
        gridPane.getChildren().add(cell4);
        gridPane.getChildren().add(cell5);
        gridPane.getChildren().add(cell6);
        gridPane.getChildren().add(cell7);
        gridPane.getChildren().add(cell8);
        getChildren().add(gridPane);
        getChildren().add(separator);
        getChildren().add(vsText);
        getChildren().add(player1Text);
        getChildren().add(player2Text);
        getChildren().add(label8);
        gridPane.setOnMousePressed(e->{ xOffset = e.getSceneX();
            yOffset = e.getSceneY();});
        gridPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        if(mode==1 || mode==0)
        {

            this.ip=ip;
            this.mode=mode;
            this.p=(NetworkPlayer)player;
            this.p2=(NetworkPlayer)player2;
            this.startGame=new TicTacToe2(this.p,this.p2);
            label8.setText("X");

        player1Text.setText(startGame.player1.name);
        player2Text.setText(startGame.player2.name);
            connect();
        }
    }

    public void connect()
    {
        try {
            if(this.mode==0){
            dis=new DataInputStream(p.socket.getInputStream());
            dos=new DataOutputStream(p.socket.getOutputStream());}
            else
            {
              dis=new DataInputStream(p2.socket.getInputStream());
              dos=new DataOutputStream(p2.socket.getOutputStream());
            }
            sg=new StartGame();
        } catch (IOException ex) {
            Logger.getLogger(TicTacToeGamePageBase.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    public void putXOrO(int cellNo,char mode){
        switch(cellNo){
                        case 8:
                                if(mode=='X')
                                Platform.runLater(()->cell8.setGraphic(imagecell8ViewX));
                                else
                                 Platform.runLater(()->cell8.setGraphic(imagecell8ViewO));
                                break;
                        case 0:
                                if(mode=='X')
                                Platform.runLater(()->cell0.setGraphic(imagecell0ViewX));
                                else
                                 Platform.runLater(()->cell0.setGraphic(imagecell0ViewO));
                                break;
                        case 1:
                                 if(mode=='X')
                                Platform.runLater(()->cell1.setGraphic(imagecell1ViewX));
                                else
                                Platform.runLater(()->cell1.setGraphic(imagecell1ViewO));
                                break;
                        case 2:
                                if(mode=='X')
                                Platform.runLater(()->cell2.setGraphic(imagecell2ViewX));
                                else
                                Platform.runLater(()->cell2.setGraphic(imagecell2ViewO));
                                break;
                        case 3:
                                if(mode=='X')
                                Platform.runLater(()->cell3.setGraphic(imagecell3ViewX));
                                else
                                Platform.runLater(()->cell3.setGraphic(imagecell3ViewO));
                                break;
                        case 4:
                                if(mode=='X')
                                Platform.runLater(()->cell4.setGraphic(imagecell4ViewX));
                                else
                                Platform.runLater(()->cell4.setGraphic(imagecell4ViewO));
                                break;
                        case 5:
                                 if(mode=='X')
                                Platform.runLater(()->cell5.setGraphic(imagecell5ViewX));
                                else
                                Platform.runLater(()->cell5.setGraphic(imagecell5ViewO));
                                break;

                         case 6:
                                 if(mode=='X')
                                Platform.runLater(()->cell6.setGraphic(imagecell6ViewX));
                                else
                                Platform.runLater(()->cell6.setGraphic(imagecell6ViewO));
                                break;
                        case 7:
                                 if(mode=='X')
                                Platform.runLater(()->cell7.setGraphic(imagecell7ViewX));
                                else
                                Platform.runLater(()->cell7.setGraphic(imagecell7ViewO));
                                break;
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

            while(true)
            {
                    int data;
                  try {
                      data = dis.readInt();
                      if(Double.isNaN((double)data))
                      {
                           if(p.turn)
                           {
                               Platform.runLater(()->
                               {
                                   Stage s=new Stage();
                                   OnePlayerIsDownBase p2=new OnePlayerIsDownBase();
                                   p2.label.setText(p.name+" is offline ");
                                   s.setScene(new Scene(p2));
                                   s.show();
                                  System.exit(0);

                               }
                               );
                           }
                           else
                           {
                           Platform.runLater(()->
                               {
                                   Stage s=new Stage();
                                   OnePlayerIsDownBase p3=new OnePlayerIsDownBase();
                                   p3.label.setText(p2.name+" is offline ");
                                   s.setScene(new Scene(p3));
                                   s.show();
                                  System.exit(0);

                               }
                               );
                           }
                      }

                      startGame.HoldPlace(data);


                           switch(data){
                        case 8:
                                if(p.turn)
                                Platform.runLater(()->cell8.setGraphic(imagecell8ViewX));
                                else
                                 Platform.runLater(()->cell8.setGraphic(imagecell8ViewO));
                                break;
                        case 0:
                                if(p.turn)
                                Platform.runLater(()->cell0.setGraphic(imagecell0ViewX));
                                else
                                 Platform.runLater(()->cell0.setGraphic(imagecell0ViewO));
                                break;
                        case 1:
                                if(p.turn)
                                Platform.runLater(()->cell1.setGraphic(imagecell1ViewX));
                                else
                                Platform.runLater(()->cell1.setGraphic(imagecell1ViewO));
                                break;
                        case 2:
                                if(p.turn)
                                Platform.runLater(()->cell2.setGraphic(imagecell2ViewX));
                                else
                                Platform.runLater(()->cell2.setGraphic(imagecell2ViewO));
                                break;
                        case 3:
                               if(p.turn)
                                Platform.runLater(()->cell3.setGraphic(imagecell3ViewX));
                                else
                                Platform.runLater(()->cell3.setGraphic(imagecell3ViewO));
                                break;
                        case 4:
                                if(p.turn)
                                Platform.runLater(()->cell4.setGraphic(imagecell4ViewX));
                                else
                                Platform.runLater(()->cell4.setGraphic(imagecell4ViewO));
                                break;
                        case 5:
                                if(p.turn)
                                Platform.runLater(()->cell5.setGraphic(imagecell5ViewX));
                                else
                                Platform.runLater(()->cell5.setGraphic(imagecell5ViewO));
                                break;

                         case 6:
                                if(p.turn)
                                Platform.runLater(()->cell6.setGraphic(imagecell6ViewX));
                                else
                                Platform.runLater(()->cell6.setGraphic(imagecell6ViewO));
                                break;
                        case 7:
                                if(p.turn)
                                Platform.runLater(()->cell7.setGraphic(imagecell7ViewX));
                                else
                                Platform.runLater(()->cell7.setGraphic(imagecell7ViewO));
                                break;
                    }
                         if(p.turn)
                                {
                                    startGame.player1.moves.add(data);
                                     if( startGame.CheckWinner(0))
                                   {
                                       startGame.Finish(0);
                                       System.out.println("oppenet winnner");
                                       break;
                                   }
                                }
                                else
                                {
                                    startGame.player2.moves.add(data);
                                     if( startGame.CheckWinner(1))
                                   {
                                       startGame.Finish(1);
                                       System.out.println(" oppenet winnner");
                                       break;
                                   }
                                }
                  p.turn=(p.turn)?false:true;
                    p2.turn=(p2.turn)?false:true;
                }
                   catch (IOException ex) {
                        if(p.turn)
                           {
                               Platform.runLater(()->
                               {
                                   Stage s=new Stage();
                                   OnePlayerIsDownBase p2=new OnePlayerIsDownBase();
                                   System.out.println(p.name+" is offline ");
                                   p2.text.setText(p.name+" is offline ");
                                   s.setScene(new Scene(p2));
                                   s.show();


                               }
                               );
                               break;
                           }
                           else
                           {
                           Platform.runLater(()->
                               {
                                   Stage s=new Stage();
                                   OnePlayerIsDownBase p3=new OnePlayerIsDownBase();
                                    System.out.println(p2.name+" is offline ");
                                   p3.text.setText(p2.name+" is offline ");
                                   s.setScene(new Scene(p3));
                                   s.show();



                               }
                               );
                            break;
                           }
                        }
            }


    }}

}
