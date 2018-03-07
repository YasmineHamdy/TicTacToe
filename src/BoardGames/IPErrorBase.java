package BoardGames;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class IPErrorBase extends AnchorPane {

    protected final Pane pane;
    protected final Label label;
    protected final Button button;

    public IPErrorBase() {

        pane = new Pane();
        label = new Label();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(139.0);
        setPrefWidth(502.0);

        pane.setLayoutX(3.0);
        pane.setPrefHeight(136.0);
        pane.setPrefWidth(496.0);

        label.setLayoutX(80.0);
        label.setLayoutY(31.0);
        label.setPrefHeight(17.0);
        label.setPrefWidth(337.0);
        label.setText("IP is Wrong Check it and try to enter it again");

        button.setLayoutX(365.0);
        button.setLayoutY(95.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(25.0);
        button.setPrefWidth(71.0);
        button.setText("ok");

        pane.getChildren().add(label);
        pane.getChildren().add(button);
        getChildren().add(pane);

    }
}
