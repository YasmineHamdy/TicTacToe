package BoardGames;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class WaitingForConnectionBase extends AnchorPane {

    protected final Label label;

    public WaitingForConnectionBase() {

        label = new Label();

        setId("AnchorPane");
        setPrefHeight(90.0);
        setPrefWidth(376.0);

        label.setLayoutX(111.0);
        label.setLayoutY(37.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(154.0);
        label.setText("waitingfor connection!!");

        getChildren().add(label);

    }
}
