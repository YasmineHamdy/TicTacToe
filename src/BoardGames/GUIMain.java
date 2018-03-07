package BoardGames;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class GUIMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Player player1=new Player();
        Player player2=new Player();
        
        TicTacToe run = new TicTacToe(primaryStage,player1, player2);
        
        
        MainMenuPageBase mainPage = new MainMenuPageBase(); 
        TicTacToeMenuPageBase tictactoePage = new TicTacToeMenuPageBase();
        NamePageBase namePage = new NamePageBase();
        TicTacToeLevelsPageBase levelsPage = new TicTacToeLevelsPageBase();
        TicTacToeGamePageBase startTTTGamePage = new TicTacToeGamePageBase(primaryStage,2,null,null);
        whoInitiatesPageBase whoPage = new whoInitiatesPageBase (primaryStage);

        waitPageBase waitPage = new waitPageBase();
        NamePage2Base namePage2 = new NamePage2Base();

                
        Scene mainScene = new Scene(mainPage,Color.TRANSPARENT);
        Scene tictactoeScene = new Scene(tictactoePage,Color.TRANSPARENT);
        Scene nameScene = new Scene(namePage,Color.TRANSPARENT);
        Scene levelsScene = new Scene(levelsPage,Color.TRANSPARENT);
        Scene startTTTGameScene = new Scene(startTTTGamePage,Color.TRANSPARENT);
        Scene whoScene = new Scene(whoPage,Color.TRANSPARENT);
       
        Scene waitScene = new Scene(waitPage,Color.TRANSPARENT);
        Scene name2Scene = new Scene(namePage2,Color.TRANSPARENT);

        
        //main menu.
        mainPage.tttButton.setOnAction(e -> {
            primaryStage.setScene(nameScene);
        });
        
        
        
        namePage.okButton.setOnAction(event -> {
            //set first player name.
            Globals.name1=namePage.textField.getText();
            tictactoePage.name=namePage.textField.getText();
            primaryStage.setScene(tictactoeScene);
        });
        
        namePage.backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        
        
        tictactoePage.backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        
        tictactoePage.pcButton.setOnAction(event -> {
            Globals.name2="Computer";
            primaryStage.setScene(levelsScene);
        });
        
        
        levelsPage.backButton.setOnAction(event -> {
            primaryStage.setScene(tictactoeScene);
        });
        
        levelsPage.level1.setOnMouseClicked((MouseEvent e) -> {
            Globals.level=1;
            Globals.gameType=1;
            run.run();
         
        });
        
       
        levelsPage.level2.setOnMouseClicked((MouseEvent e) -> {
            Globals.level=2;
            Globals.gameType=1;
            run.run();
        });
        levelsPage.level3.setOnMouseClicked((MouseEvent e) -> {
            Globals.level=3;
            Globals.gameType=1;
            primaryStage.setScene(startTTTGameScene);
        });
        
        startTTTGamePage.backButton.setOnMouseClicked((MouseEvent e) -> {
            primaryStage.setScene(tictactoeScene);
        });
        tictactoePage.playerButton.setOnAction(e -> {
            Globals.gameType=2;
            primaryStage.setScene(name2Scene);
        });
        
        namePage2.okButton.setOnAction(event -> {
            //set player 2 name.
            Globals.name2=namePage2.textField.getText();
             run.run();
        });
        namePage2.backButton.setOnAction(event -> {
            primaryStage.setScene(levelsScene);
        });
        
        tictactoePage.networkButton.setOnAction(e -> {
            Globals.gameType=3;
            whoPage.name=tictactoePage.name;
            primaryStage.setScene(whoScene);
        });
       
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        
    }
    
    
    
    
}
