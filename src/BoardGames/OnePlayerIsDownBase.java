package BoardGames;

import static java.awt.SystemColor.text;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class OnePlayerIsDownBase extends AnchorPane {

    protected final Pane pane;
    protected Label label;
    protected final Text text;
    public OnePlayerIsDownBase() {

        pane = new Pane();
        text = new Text();

        setId("AnchorPane");    
        setPrefHeight(149.0);
        setPrefWidth(464.0);

        pane.setLayoutX(15.0);
        pane.setLayoutY(9.0);
        pane.setPrefHeight(132.0);
        pane.setPrefWidth(438.0);

        text.setLayoutX(74.0);
        text.setLayoutY(58.0);
      
        

        pane.getChildren().add(text);
        getChildren().add(pane);

    }
}
