package BoardGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



public abstract class Computer implements PlayerInterface{
    String [] board;
    String empty,stone;
    
    public Computer() {
        this.board =  new String[]{empty,empty,empty,empty,empty,empty,empty,empty,empty};  
        this.stone = empty;
    }
    
}


class Dummy extends Computer{
    @Override
    public int play(String []board, String stone, ArrayList<Integer> randomNo){
        this.board = board;
        this.stone = stone;
        
        Random rand = new Random();
        int x = randomNo.get(rand.nextInt(randomNo.size()));
        return x;
    }
}


class Intermediate extends Computer{
    @Override
    public int play(String []board, String stone, ArrayList<Integer> randomNo){
        this.board = board;
        this.stone = stone;
        
        Random rand = new Random();
        int x = randomNo.get(rand.nextInt(randomNo.size()));
        return x;
    }
}


class Advanced extends Computer{
    @Override
    public int play(String []board, String stone, ArrayList<Integer> randomNo){
        this.board = board;
        this.stone = stone;
        
        Random rand = new Random();
        int x = randomNo.get(rand.nextInt(randomNo.size()));
        return x;
    }
}

