package BoardGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random ;
import java.util.Scanner;


public class Player implements PlayerInterface{

    String [] board;
    String empty,stone;
    int input;
    
    public Player() {
        this.board =  new String[]{empty,empty,empty,empty,empty,empty,empty,empty,empty};  
        this.stone = empty;
    }
    
    @Override
    public int play(String []board, String stone, ArrayList<Integer> randomNo){
        this.board = board;
        this.stone = stone;
        
        System.out.println("please click on a cell player 1. ");

        while(TicTacToeGamePageBase.pos==-1){
            System.out.println(TicTacToeGamePageBase.pos);
            System.out.println("please click on a cell player 1. ");


        }
        if(TicTacToeGamePageBase.pos==0){
            input = 0;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==1){
            input = 1;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==2){
            input = 2;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==3){
            input = 3;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==4){
            input = 4;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==5){
            input = 5;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==6){
            input = 6;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==7){
            input = 7;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        else if(TicTacToeGamePageBase.pos==8){
            input = 8;
            System.out.println(TicTacToeGamePageBase.pos);
            TicTacToeGamePageBase.pos=-1;
        }
        
        //Scanner scanner = new Scanner( System.in );
//        System.out.println("please enter a field: ");
//        while(Globals.pos==-1);
//            if(Globals.pos==0 && Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=0;
//                Globals.pos=-1;
//            }else if(Globals.pos==3&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=3;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==6&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=6;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==2&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=2;
//                Globals.pos=-1;
//            }else if(Globals.pos==4&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=4;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==7&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=7;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==5&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=5;
//                Globals.pos=-1;
//            }else if(Globals.pos==8&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=8;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==1&& Globals.firstTurn){
//                System.out.println(Globals.pos);
//                input=1;
//                Globals.pos=-1;
//            }
//        
//        System.out.println(input);
//        
//        Globals.firstTurn = false;
        return input; 
    }
    
}
