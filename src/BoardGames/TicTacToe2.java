/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardGames;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TicTacToe2 {
    NetworkPlayer player1;
    NetworkPlayer player2;
    String Winner="";
    int movesLeft;
    boolean GameEnded=false;

     int [][] winningStates = {
                                {0, 1, 2},
                                {6, 4, 5},
                                {3, 7, 8},
                                {0, 4, 8},
                                {3, 4, 2},
                                {0, 6, 3},
                                {1, 4, 7},
                                {2, 5, 8}
                            };
     
     ArrayList<Integer> availablePlaces=new ArrayList<Integer>();
     
    TicTacToe2(NetworkPlayer p1,NetworkPlayer p2)
    {
        this.player1=p1;
        this.player2=p2;
        this.movesLeft=9;
        this.availablePlaces.add(0);
        this.availablePlaces.add(1);
        this.availablePlaces.add(2);
        this.availablePlaces.add(3);
        this.availablePlaces.add(4);
        this.availablePlaces.add(5);
        this.availablePlaces.add(6);
        this.availablePlaces.add(7);
        this.availablePlaces.add(8);
       
    }
    void HoldPlace(int element){
        this.availablePlaces.remove(this.availablePlaces.indexOf(element));
    }
    boolean CheckPlace(int element)
    {
        return this.availablePlaces.contains(element);
    }
    
    void Finish(int n)
    {
        this.GameEnded=true;
 
        AskForStoreBase s=new AskForStoreBase();
       Platform.runLater(()->{
           Stage stage=new Stage();

        stage.setScene(new Scene(s));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();  
          s.button0.setOnMousePressed(ev->{
          Platform.runLater(()->{ stage.close();});
              try(FileWriter fw = new FileWriter("myGames.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw))
        {
            out.println("{");
            
            out.print(player1.moves.toString()+";");
            out.print(player2.moves.toString()+";");
            out.print(player1.name+";");
            out.print(player2.name+";");
            out.println((n==0?player1.name:(n==1?player2.name:"no winner")));
            
            out.println("}");
            //more code
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
                    System.out.println("error");
        }
//          String[] row=new String[5];
//          row[0]=player1.moves.toString();
//          row[1]=player2.moves.toString();
//          row[2]=player1.name;
//          row[3]=player2.name;
//          row[4]=n==0?player1.name:(n==1?player2.name:"no winner");
//          db.write(row);
       });
       });
     
        
     
        
    }
   
   boolean CheckWinner(int no)
    {
   
        movesLeft--;
        if(no==0)
        {
             for(int[]win:winningStates){
                    int counter = 0;
                    for(int j=0; j<win.length;j++){
                       if(player1.moves.contains(win[j])){
                           counter++;
                           if(counter==3){
                              return true;
                           }      
                       }
                    }
                }
        }
        else
        {
               for(int[]win:winningStates){
                    int counter = 0;
                    for(int j=0; j<win.length;j++){
                       if(player2.moves.contains(win[j])){
                           counter++;
                           if(counter==3){
                              return true;
                           }      
                       }
                    }
                }
        }
        if(movesLeft==0)
        {
            Finish(2);
        }
        return false;
    }
}
