package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.BelegSoort;
import model.database.BelegDatabase;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BelegPane extends GridPane {
    private TableView<BelegSoort> table;
    private ObservableList<BelegSoort> belegsoorten;

    public BelegPane(BelegDatabase belegDatabase){
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 550));
        Label lblHeading = new Label("Beleg Inventory");
        lblHeading.setFont(new Font("Arial", 20));
        table = new TableView<BelegSoort>();
        refresh(belegDatabase);
        TableColumn<BelegSoort, String> colBelegSoortNaam = new TableColumn<BelegSoort, String>("Belegnaam");
        colBelegSoortNaam.setMinWidth(300);
        colBelegSoortNaam.setCellValueFactory(new PropertyValueFactory<BelegSoort, String>("belegNaam"));
        TableColumn<BelegSoort, Double> colBelegPrijs = new TableColumn<BelegSoort, Double>("Belegprijs");
        colBelegPrijs.setMinWidth(100);
        colBelegPrijs.setCellValueFactory(new PropertyValueFactory<BelegSoort, Double>("belegPrijs"));
        TableColumn<BelegSoort, Integer> colBelegStock = new TableColumn<BelegSoort, Integer>("Belegstock");
        colBelegStock.setMinWidth(100);
        colBelegStock.setCellValueFactory(new PropertyValueFactory<BelegSoort, Integer>("belegStock"));
        table.getColumns().addAll(colBelegSoortNaam,colBelegPrijs,colBelegStock);

        root.getChildren().addAll(lblHeading, table);

        this.getChildren().addAll(root);
    }

    public void refresh(BelegDatabase belegDatabase){
        belegsoorten = FXCollections.observableArrayList(belegDatabase.belegSoortMapToList());
        table.setItems(belegsoorten);
        table.refresh();
    }
}
