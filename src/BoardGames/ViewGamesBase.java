package BoardGames;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.layout.AnchorPane;

public class ViewGamesBase extends AnchorPane {

    protected final ScrollPane scrollPane;
    protected final TableView <String> tableView;
    protected final TableColumn <String,String>tableColumn;

    public ViewGamesBase() {

        scrollPane = new ScrollPane();
        tableView = new TableView();
        
        tableColumn = new TableColumn();
        
        setId("AnchorPane");
        
        setPrefHeight(284.0);
        setPrefWidth(490.0);

        scrollPane.setLayoutX(6.0);
        scrollPane.setLayoutY(7.0);
        scrollPane.setPrefHeight(263.0);
        scrollPane.setPrefWidth(486.0);

        tableView.setPrefHeight(253.0);
        tableView.setPrefWidth(470.0);

        tableColumn.setPrefWidth(tableView.getPrefWidth());
        tableColumn.setText("games");
        tableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        
        tableView.getColumns().add(tableColumn);
       
        tableView.setEditable(true);
        scrollPane.setContent(tableView);

        
        getChildren().add(scrollPane);

    }
}
