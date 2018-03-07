package BoardGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random ;
import java.util.Scanner;


public class Player2 implements PlayerInterface{

    String [] board;
    String empty,stone;
    int input;
    
    public Player2() {
        this.board =  new String[]{empty,empty,empty,empty,empty,empty,empty,empty,empty};  
        this.stone = empty;
    }
    
    @Override
    public int play(String []board, String stone, ArrayList<Integer> randomNo){
        this.board = board;
        this.stone = stone;
        
        //Scanner scanner = new Scanner( System.in );
        System.out.println("please click on a cell player 1.");
        while(TicTacToeGamePageBase.pos==-1){
            System.out.println(TicTacToeGamePageBase.pos);
            System.out.println("please click on a cell player 2.");

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
    
//        while(Globals.pos==-1);
//            if(Globals.pos==0 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=0;
//                Globals.pos=-1;
//            }else if(Globals.pos==3 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=3;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==6 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=6;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==2 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=2;
//                Globals.pos=-1;
//            }else if(Globals.pos==4 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=4;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==7 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=7;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==5 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=5;
//                Globals.pos=-1;
//            }else if(Globals.pos==8 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=8;
//                Globals.pos=-1;
//            }
//            else if(Globals.pos==1 && Globals.secondtTurn){
//                System.out.println(Globals.pos);
//                input=1;
//                Globals.pos=-1;
//            }
//        
//        System.out.println(input);
//        
//        Globals.secondtTurn = false;
        
        return input; 
    }
    
}
