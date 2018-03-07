package BoardGames;

import java.net.Socket;
import java.util.ArrayList;


public class NetworkPlayer implements PlayerInterface{
    String stone;
    String name;
    boolean turn;
    Socket socket;
    ArrayList<Integer>moves;
    public NetworkPlayer(int mode,boolean turn,String name,Socket s) {
        if(mode==0)
            this.stone ="x";
        else 
          this.stone="o";
       this.turn=turn;
        this.name=name;
        this.socket=s;
        this.moves=new ArrayList<Integer>();
    }

    @Override
    public int play(String[] board, String stone, ArrayList<Integer> randomNo) {
        return 0;
      }
   
    
}
