package BoardGames;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AskForStoreBase extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final Button button;
    protected final Button button0;

    public AskForStoreBase() {

        pane = new Pane();
        label = new Label();
        button = new Button();
        button0 = new Button();

        setId("AnchorPane");
        setPrefHeight(111.0);
        setPrefWidth(323.0);

        pane.setLayoutX(4.0);
        pane.setLayoutY(3.0);
        pane.setPrefHeight(105.0);
        pane.setPrefWidth(315.0);

        label.setLayoutX(57.0);
        label.setLayoutY(32.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(210.0);
        label.setText("Do you want to save the Match?");

        button.setLayoutX(221.0);
        button.setLayoutY(66.0);
        button.setMnemonicParsing(false);
        button.setText("No");

        button0.setLayoutX(50.0);
        button0.setLayoutY(66.0);
        button0.setMnemonicParsing(false);
        button0.setText("Yes");

        pane.getChildren().add(label);
        pane.getChildren().add(button);
        pane.getChildren().add(button0);
        getChildren().add(pane);

    }
}
