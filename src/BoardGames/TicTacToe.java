package BoardGames;

import BoardGames.PlayerInterface;
import BoardGames.Player2;
import BoardGames.Player;
import BoardGames.NetworkPlayer;
import BoardGames.Computer;
import java.io.File;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.BreakNode;


//this is a class for saving an object of type player, his name and the turn("x" or "o").
class User{
    public PlayerInterface userPlayer;
    String name;
    String turn;

    public User(PlayerInterface userPlayer,String name, String turn) {
        this.userPlayer=userPlayer;
        this.name=name;
        this.turn=turn;
    }
    
}

//this is a custom return class.
class ReturnHandler {
    private String theWinner; //winner
    private String[] finalBoard; //the final board
    private String player1Name;
    private String player2Name;
    private List<Integer> player1Moves;
    private List<Integer> player2Moves;
    
    
    public void setWinner(String s){
        this.theWinner = s;
    }
  
    public String getWinner(){
        return this.theWinner;
    }

    public void setFinalBoard(String[] d){
        this.finalBoard = d;
    }

    public String[] getFinalBoard(){
        return this.finalBoard;
    }
    
    public void setplaye1Name(String playe1Name){
        this.player1Name = playe1Name;
    }

    public String getplaye1Name(){
        return this.player1Name;
    }
    
    public void setplayer2Name(String player2Name){
        this.player2Name = player2Name;
    }

    public String getplayer2Name(){
        return this.player2Name;
    }
    
    public void setplayer1Moves(List<Integer> player1Moves){
        this.player1Moves = player1Moves;
    }

    public List<Integer>  getplayer1Moves(){
        return this.player1Moves;
    }
    
    public void setplayer2Moves(List<Integer> player2Moves){
        this.player2Moves = player2Moves;
    }

    public List<Integer>   getplayer2Moves(){
        return this.player2Moves;
    }
    
}


public class TicTacToe {
    Stage primaryStage;
    TicTacToeGamePageBase startTTTGamePage = new TicTacToeGamePageBase(primaryStage,2,null,null);
    WinnerPageBase resultPage = new WinnerPageBase();
    
    int removeNo= -1;
    ArrayList<Integer> availableList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8));
    String empty,x,o,turn,winner;
    String [] board;
    boolean isGameEnded, isWinner, isGameStarted;
    User userPlayer;
    User userPlayer2;

    public User getUserPlayer() {
        return userPlayer;
    }

    public void setUserPlayer(User userPlayer) {
        this.userPlayer = userPlayer;
    }

    public User getUserPlayer2() {
        return userPlayer2;
    }

    public void setUserPlayer2(User userPlayer2) {
        this.userPlayer2 = userPlayer2;
    }

    int [][] winningStates = {
                                {0, 1, 2},
                                {3, 4, 5},
                                {6, 7, 8},
                                {0, 3, 6},
                                {1, 4, 7},
                                {2, 5, 8},
                                {0, 4, 8},
                                {2, 4, 6}
                            };
    
    
  
    public TicTacToe(Stage primaryStage, PlayerInterface userPlayer, PlayerInterface userPlayer2){
        this.x = "x";
        this.o = "o";
        this.empty = empty;
        this.isGameEnded = false;
        this.isWinner = false;
        this.isGameStarted = false;
        this.winner = empty;
        this.turn = x;
        this.board =  new String[]{empty,empty,empty,empty,empty,empty,empty,empty,empty};  
        this.userPlayer = new User(userPlayer,empty, empty);
        this.userPlayer2 = new User(userPlayer2,empty, empty);
        this.primaryStage = primaryStage;
    }
    
    public void run() {
        Player player1=new Player();   
        Advanced advanced = new Advanced();

        Player2 player2=new Player2();
        
        NamePageBase namePage = new NamePageBase();
        NamePage2Base name2Page = new NamePage2Base();
        
        Scene ttt = new Scene(startTTTGamePage);
        this.primaryStage.setScene(ttt);

        
        new Thread(new Runnable() {
    
        @Override
        public void run() {
            
            
        switch (Globals.gameType) {
            case 1:{
                switch(Globals.level){
                    case 1:{
                        
                        System.out.print("level no: "+Globals.level+"\n");
                        userPlayer=new User(player1, empty, empty);
                        userPlayer2=new User(advanced, empty, empty);
                        userPlayer.name=Globals.name1;
                        userPlayer2.name=Globals.name2;
                        startTTTGamePage.player1Text.setText(userPlayer.name);
                        startTTTGamePage.player2Text.setText(userPlayer2.name);
                        
                        System.out.print("first player: "+userPlayer.name+"\n"+"second player: "+ userPlayer2.name+"\n");

                        ReturnHandler r = takeTurns();
                        System.out.println("winnner is: "+r.getWinner()+"\n");
                        System.out.println("player 1 name is: "+r.getplaye1Name()+"\n");
                        System.out.println("player 2 name is: "+r.getplayer2Name()+"\n");
                        System.out.println("player 1 moves: "+r.getplayer1Moves()+"\n");
                        System.out.println("player 2 moves: "+r.getplayer2Moves()+"\n");
                        
                        for (int i = 0; i < 9; i++) {
                            System.out.print(r.getFinalBoard()[i] + "  ");
                            if((i==2) || (i==5) || (i==8)){
                                System.out.print("\n");
                            }
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Scene result = new Scene(resultPage);
                                TicTacToe.this.primaryStage.setScene(result);
                                resultPage.text.setText(r.getWinner()+" Won!");
                        }});
                        break;
                    }
                    
                    case 2:{
                        
                        System.out.print("level no: "+Globals.level+"\n");
                        userPlayer=new User(player1, empty, empty);
                        userPlayer2=new User(advanced, empty, empty);
                        userPlayer.name=Globals.name1;
                        userPlayer2.name=Globals.name2;                        
                        startTTTGamePage.player1Text.setText(userPlayer.name);
                        startTTTGamePage.player2Text.setText(userPlayer2.name);
                        
                        System.out.print("first player: "+userPlayer.name+"\n"+"second player: "+ userPlayer2.name+"\n");

                        ReturnHandler r = takeTurns();
                        System.out.println("winnner is: "+r.getWinner()+"\n");
                        System.out.println("player 1 name is: "+r.getplaye1Name()+"\n");
                        System.out.println("player 2 name is: "+r.getplayer2Name()+"\n");
                        System.out.println("player 1 moves: "+r.getplayer1Moves()+"\n");
                        System.out.println("player 2 moves: "+r.getplayer2Moves()+"\n");
                        for (int i = 0; i < 9; i++) {
                            System.out.print(r.getFinalBoard()[i] + "  ");
                            if((i==2) || (i==5) || (i==8)){
                                System.out.print("\n");
                            }
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Scene result = new Scene(resultPage);
                                TicTacToe.this.primaryStage.setScene(result);
                                resultPage.text.setText(r.getWinner()+" Won!");
                        }});
                    }
                    
                    case 3:{
                        
                        System.out.print("level no: "+Globals.level+"\n");
                        userPlayer=new User(player1, empty, empty);
                        userPlayer2=new User(advanced, empty, empty);
                        userPlayer.name=Globals.name1;
                        userPlayer2.name=Globals.name2;                        
                        startTTTGamePage.player1Text.setText(userPlayer.name);
                        startTTTGamePage.player2Text.setText(userPlayer2.name);
                        
                        System.out.print("first player: "+userPlayer.name+"\n"+"second player: "+ userPlayer2.name+"\n");

                        ReturnHandler r = takeTurns();
                        System.out.println("winnner is: "+r.getWinner()+"\n");
                        System.out.println("player 1 name is: "+r.getplaye1Name()+"\n");
                        System.out.println("player 2 name is: "+r.getplayer2Name()+"\n");
                        System.out.println("player 1 moves: "+r.getplayer1Moves()+"\n");
                        System.out.println("player 2 moves: "+r.getplayer2Moves()+"\n");
                        
                        for (int i = 0; i < 9; i++) {
                            System.out.print(r.getFinalBoard()[i] + "  ");
                            if((i==2) || (i==5) || (i==8)){
                                System.out.print("\n");
                            }
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Scene result = new Scene(resultPage);
                                TicTacToe.this.primaryStage.setScene(result);
                                resultPage.text.setText(r.getWinner()+" Won!");
                        }});
                        break;
                    }
                }    
                break;
            }
            
            case 2:{
                
                        System.out.print("level no: "+Globals.level+"\n");
                        userPlayer=new User(player1, empty, empty);
                        userPlayer2=new User(player2, empty, empty);
                        userPlayer.name=Globals.name1;
                        userPlayer2.name=Globals.name2;
                        startTTTGamePage.player1Text.setText(userPlayer.name);
                        startTTTGamePage.player2Text.setText(userPlayer2.name);
                        
                        System.out.print("first player: "+userPlayer.name+"\n"+"second player: "+ userPlayer2.name+"\n");

                        ReturnHandler r = takeTurns();
                        System.out.println("winnner is: "+r.getWinner()+"\n");
                        System.out.println("player 1 name is: "+r.getplaye1Name()+"\n");
                        System.out.println("player 2 name is: "+r.getplayer2Name()+"\n");
                        System.out.println("player 1 moves: "+r.getplayer1Moves()+"\n");
                        System.out.println("player 2 moves: "+r.getplayer2Moves()+"\n");

                        for (int i = 0; i < 9; i++) {
                            System.out.print(r.getFinalBoard()[i] + "  ");
                            if((i==2) || (i==5) || (i==8)){
                                System.out.print("\n");
                            }
                        }
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Scene result = new Scene(resultPage);
                                TicTacToe.this.primaryStage.setScene(result);
                                resultPage.text.setText(r.getWinner()+" Won!");
                        }});
                    break;
                }
        
            default:
                break;
        }
        }    
        }).start();
        
        
    }
    
    
    public void display( ){
        for (int i = 0; i < 9; i++) {
            System.out.print(this.board[i] = "-");
            if((i==2) || (i==5) || (i==8)){
                System.out.print("\n");
            }
        }
    }
    
    public void whoGoFirst(){
        Random r = new Random();
        String c = r.nextBoolean() ? this.x : this.o;
        this.turn = c;
        if ("x".equals(c)){
            this.userPlayer.turn="x";
            this.userPlayer2.turn="o";
        }else{
            this.userPlayer2.turn="o";
            this.userPlayer.turn="x";
        }            
        this.isGameStarted = true;
    }
    
   
    public void makeMove(String stone, int pos){
        if(isGameEnded==true){
            Platform.exit();
        }
        else{
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (board[pos] == null){
                    board[pos] = stone;
                    Map<Integer, String> n = new HashMap<Integer, String>();
                    n.put(0,"cell" + pos);
                    Object value = n.get(0);
                    File fx = new File("./images/x.png");
                    Image imgx = new Image(fx.toURI().toString());

                    File fo = new File("./images/o.png");
                    Image imgo = new Image(fo.toURI().toString());
                    
                    String myStone = stone.toUpperCase();
                    n.put(1, "imagecell" + pos + "View"+myStone);
                    Object imgValue = n.get(1);
                    
                    try{
                        Label cell = (Label) startTTTGamePage.lookup("#"+value);
                        if(stone.equals("x")){
                            if(pos==0)
                                cell.setGraphic(startTTTGamePage.imagecell0ViewX);
                            else if(pos==1)
                                cell.setGraphic(startTTTGamePage.imagecell1ViewX);
                            else if(pos==2)
                                cell.setGraphic(startTTTGamePage.imagecell2ViewX);
                            else if(pos==3)
                                cell.setGraphic(startTTTGamePage.imagecell3ViewX);
                            else if(pos==4)
                                cell.setGraphic(startTTTGamePage.imagecell4ViewX);
                            else if(pos==5)
                                cell.setGraphic(startTTTGamePage.imagecell5ViewX);
                            else if(pos==6)
                                cell.setGraphic(startTTTGamePage.imagecell6ViewX);
                            else if(pos==7)
                                cell.setGraphic(startTTTGamePage.imagecell7ViewX);
                            else if(pos==8)
                                cell.setGraphic(startTTTGamePage.imagecell8ViewX);
                        }else{
                            if(pos==0)
                                cell.setGraphic(startTTTGamePage.imagecell0ViewO);
                            else if(pos==1)
                                cell.setGraphic(startTTTGamePage.imagecell1ViewO);
                            else if(pos==2)
                                cell.setGraphic(startTTTGamePage.imagecell2ViewO);
                            else if(pos==3)
                                cell.setGraphic(startTTTGamePage.imagecell3ViewO);
                            else if(pos==4)
                                cell.setGraphic(startTTTGamePage.imagecell4ViewO);
                            else if(pos==5)
                                cell.setGraphic(startTTTGamePage.imagecell5ViewO);
                            else if(pos==6)
                                cell.setGraphic(startTTTGamePage.imagecell6ViewO);
                            else if(pos==7)
                                cell.setGraphic(startTTTGamePage.imagecell7ViewO);
                            else if(pos==8)
                                cell.setGraphic(startTTTGamePage.imagecell8ViewO);

                        }
                    }catch(Exception e){
                        System.err.println("something went wrong!");
                    }
                }
                else{
                    takeTurns();
                }  
            }});
        }
    }
    
    List<Integer> player1movesList = new ArrayList<Integer>();
    List<Integer> player2movesList = new ArrayList<Integer>();
    public ReturnHandler takeTurns(){
        ReturnHandler r = new ReturnHandler();
        int [] player1moves;
        
        if (this.isGameStarted==false){
            this.whoGoFirst();
        }
        while(this.isGameEnded==false){
            if(availableList.size()>0){
                if (availableList.contains(removeNo)){
                    int x = availableList.indexOf(removeNo);
                    availableList.remove(x);
                }
            }
            
            if(this.userPlayer.turn.equals(this.turn)){
                Globals.enabled=true; //one click.
                Globals.firstTurn = true; //restrict players clicks.
                int position = this.userPlayer.userPlayer.play(this.board, this.userPlayer.turn, availableList);
                removeNo = position;
                this.makeMove(this.userPlayer.turn, position);
                this.turn = this.userPlayer2.turn;
                player1movesList.add(position);
                this.isWinner(this.userPlayer.turn);
                System.out.println(player1movesList);
                
            }else{
                Globals.enabled=true;
                Globals.secondtTurn = true;
                int position = this.userPlayer2.userPlayer.play(this.board, this.userPlayer2.turn, availableList);
                removeNo = position;
                this.makeMove(this.userPlayer2.turn, position);
                this.turn = this.userPlayer.turn;
                player2movesList.add(position);
                this.isWinner(this.userPlayer2.turn);
                System.out.println(player2movesList);
            }
            
        }
        
        
        
        r.setFinalBoard(this.board);
        r.setWinner(this.winner);
        r.setplaye1Name(this.userPlayer.name);
        r.setplayer2Name(this.userPlayer2.name);
        r.setplayer1Moves(player1movesList);
        r.setplayer2Moves(player2movesList);
        return r;
        
        }
    

    public void isWinner(String turn){
        Set set1 = new HashSet(Arrays.asList(player1movesList));
       Set set2 = new HashSet(Arrays.asList(player2movesList));
       
       ArrayList<Object> x = new ArrayList<Object>();
       ArrayList<Object> y = new ArrayList<Object>();
       ArrayList<Object> z = new ArrayList<Object>();

        x.addAll(player1movesList);
        y.addAll(player2movesList);
        outterloop:
        for(int[]win:winningStates){
            for(int i : win){
                z.add(i);
            }
            if(this.userPlayer.turn==turn){
                int counter=0;
                for (Object o : z) {
                     if (!x.contains(o)) // an element in B is not in A!
                        this.isWinner = false;
                     else{
                         counter++;
                         if(counter==3){
                            this.isWinner = true;
                            this.winner = this.userPlayer.name;
                            this.isGameEnded=true;
                            break outterloop;
                         }
                     }
                }
                z.removeAll(z);
            }
            else if(this.userPlayer2.turn==turn){
                int counter=0;
                for (Object o : z) {
                     if (!y.contains(o)) // an element in B is not in A!
                        this.isWinner = false;
                     else{
                         counter++;
                         if(counter==3){
                            this.isWinner = true;
                            this.winner = this.userPlayer2.name;
                            this.isGameEnded=true;
                            break outterloop;
                         }
                     }
                }
                z.removeAll(z);
            }
        }
        
        if(this.isWinner==false){
            int counter = 0;
            for (int i=0;i<this.board.length;i++) {
                if (this.board[i]=="x"||this.board[i]=="o"){
                    counter++;
                    if(counter==9){
                        this.winner="tie";
                        isGameEnded=true;
                    }
                }
            }
        }
        
        
    }
    
}
