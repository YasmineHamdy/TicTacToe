package BoardGames;

import DB.db;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeMenuPageBase extends AnchorPane {

    protected final Button pcButton;
    protected final ColorAdjust colorAdjust;
    protected final ImageView imageView;
    protected final Button playerButton;
    protected final ColorAdjust colorAdjust0;
    protected final Button networkButton;
    protected final ColorAdjust colorAdjust1;
    protected final Button exitButton;
    protected final ColorAdjust colorAdjust2;
    protected final Button backButton;
    protected final Button button3;
    protected final ColorAdjust colorAdjust3;
    static String name="";
    public TicTacToeMenuPageBase() {

        pcButton = new Button();
        colorAdjust = new ColorAdjust();
        imageView = new ImageView();
        playerButton = new Button();
        colorAdjust0 = new ColorAdjust();
        networkButton = new Button();
        colorAdjust1 = new ColorAdjust();
        exitButton = new Button();
        colorAdjust2 = new ColorAdjust();
        backButton = new Button();
        button3 = new Button();
        colorAdjust3 = new ColorAdjust();
        DB.db db=new DB.db();
        
        setId("AnchorPane");
        setPrefHeight(474.0);
        setPrefWidth(725.0);
        setStyle("-fx-background-color: black; -fx-background-radius: 25; -fx-padding: 10;");

        pcButton.setLayoutX(172.0);
        pcButton.setLayoutY(294.0);
        pcButton.setMnemonicParsing(false);
        pcButton.setPrefHeight(54.0);
        pcButton.setPrefWidth(441.0);
        pcButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");
        pcButton.setText("VS Computer");

        colorAdjust.setBrightness(-0.2);
        colorAdjust.setContrast(1.0);
        colorAdjust.setHue(-0.02);
        colorAdjust.setSaturation(1.0);
        pcButton.setEffect(colorAdjust);
        pcButton.setFont(new Font("DejaVu Serif Italic", 25.0));
        
        imageView.setFitHeight(200.0);
        imageView.setFitWidth(600.0);
        imageView.setLayoutX(56.0);
        imageView.setLayoutY(24.0);
        imageView.setPickOnBounds(true);
        File f = new File("./images/tttmarqlrg.gif");
        Image img = new Image("http://www.dsmsales.net/images/logos/tttmarqlrg.gif");

        imageView.setImage(img);

        playerButton.setLayoutX(172.0);
        playerButton.setLayoutY(371.0);
        playerButton.setMnemonicParsing(false);
        playerButton.setPrefHeight(54.0);
        playerButton.setPrefWidth(441.0);
        playerButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305; -fx-background-color: yellow;");
        playerButton.setText("VS Local Player");

        playerButton.setEffect(colorAdjust);
        playerButton.setFont(new Font("DejaVu Serif Italic", 25.0));

        networkButton.setLayoutX(172.0);
        networkButton.setLayoutY(448.0);
        networkButton.setMnemonicParsing(false);
        networkButton.setPrefHeight(54.0);
        networkButton.setPrefWidth(441.0);
        networkButton.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305;-fx-background-color: yellow;");
        networkButton.setText("VS Network Player");

        networkButton.setEffect(colorAdjust);
        networkButton.setFont(new Font("DejaVu Serif Italic", 25.0));

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

        button3.setLayoutX(22.0);
        button3.setLayoutY(32.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(24.0);
        button3.setPrefWidth(83.0);
        button3.setStyle("-fx-background-insets: 0,1,2,3,0; -fx-background-radius: 305;");
        button3.setText("Stored games");
      
        colorAdjust3.setBrightness(-0.2);
        colorAdjust3.setContrast(1.0);
        colorAdjust3.setHue(0.31);
        colorAdjust3.setSaturation(1.0);
        button3.setEffect(colorAdjust3);
        button3.setFont(new Font("DejaVu Serif Italic", 10.0));

        button3.setOnMousePressed(e->{
        String fileName = "myGames.txt";
        String line = null;
        ArrayList <String> games=new ArrayList<String>();
        String ob=new String();
//        try {
//            FileReader fileReader =new FileReader(fileName);
//            BufferedReader bufferedReader =new BufferedReader(fileReader);
          
//            while((line = bufferedReader.readLine()) != null) {
//                if(line.equals("{"))
//                {
//                    ob="";
//                }
//                else if(!line.equals("}") )
//               {
////                   System.out.println(line);
//                 ob=ob.concat(line);
//                
//               }
//                else if(line.equals("}"))
//                {
//                    
//                    games.add(ob);
//                }
//              
//                
//            }   
            Collection<String> list =new ArrayList<>();
             ArrayList<String[]> rows=db.read();
             for(int i=0;i<rows.size();i++){
                      list.add(rows.get(i)[0]+"."+rows.get(i)[3]+" VS "+rows.get(i)[4]);
                   }
    ObservableList<ObservableList<String>> csvData = FXCollections.observableArrayList();
             Platform.runLater(()->{
                   Stage stage=new Stage();
                
              ObservableList<String> details = FXCollections.observableArrayList(list);
               ViewGamesBase vg=new ViewGamesBase();
               vg.tableView.setItems(details);
               vg.tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
               TableView.TableViewSelectionModel selectionModel = vg.tableView.getSelectionModel();
               ObservableList selectedCells = selectionModel.getSelectedCells();
               TablePosition tablePosition = (TablePosition) selectedCells.get(0);
               String val = tablePosition.getTableColumn().getCellData(newSelection).toString();
          
               int no=Integer.parseInt(val.substring(0,1));
//             System.out.println(no);
               int[] moves1 = Arrays.stream(rows.get(no-1)[1].replace("[", "").replace("]", "").replace(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
               int[] moves2 = Arrays.stream(rows.get(no-1)[2].replace("[", "").replace("]", "").replace(" ", "").split(",")).mapToInt(Integer::parseInt).toArray();
               System.out.println(Arrays.toString(moves1));
               System.out.println(Arrays.toString(moves2));
               new PlayGame (moves1,moves2,rows.get(no-1)[3],rows.get(no-1)[4]);
               
//           System.out.println("Selected Value " + val);
               
            });
                Scene scene = new Scene(vg);
                   stage.setScene(scene);
                   
                   stage.show();
                });
//          bufferedReader.close();         
//        }
//        catch(FileNotFoundException ex) {
//            System.out.println("Unable to open file '" + fileName + "'");                
//        }
//        catch(IOException ex) {
//            System.out.println("Error reading file '" + fileName + "'");                  
//        }
        
        });
        getChildren().add(pcButton);
        getChildren().add(imageView);
        getChildren().add(playerButton);
        getChildren().add(networkButton);
        getChildren().add(exitButton);
        getChildren().add(backButton);
        getChildren().add(button3);

    }
    class PlayGame extends Thread
    {
        int [] moves1;
        int [] moves2;
        NetworkPlayer p,p1;
        TicTacToeGamePageBase board;
       
       PlayGame(int [] moves1,int [] moves2,String player1,String player2)
       {
           this.moves1=moves1;
           this.moves2=moves2;
           p=new NetworkPlayer(5, true, name, null);
           p1=new NetworkPlayer(5, true, name, null);
           board=new TicTacToeGamePageBase(null,5, p,p1);
           Platform.runLater(()->{
           Stage stage=new Stage();
         
           stage.setScene(new Scene(board));
           stage.show();});
           start();
       }
       @Override
       public void run()
       {
         
           for(int i=0;i<moves1.length+moves2.length;i++){
               try {
                   if(i%2==0)
                   this.board.putXOrO(moves1[(int)(i/2)],'X');
                   else
                   this.board.putXOrO(moves2[(int)(i/2)],'O');
                   
                   this.sleep(3000);  
               } catch (InterruptedException ex) {
                   Logger.getLogger(TicTacToeMenuPageBase.class.getName()).log(Level.SEVERE, null, ex);
               }
           
           }}
          
       
       }
    }
