package view.panels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.Broodje;
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;

public class KitchenPane extends BorderPane {
    private TableView<Broodje> table;
    private ObservableList<Broodje> broodjes;

    public KitchenPane() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        Label lblHeading = new Label("Kitchen View");
        lblHeading.setFont(new Font("Arial", 20));
        table = new TableView<Broodje>();

        TableColumn<Broodje, String> colBroodjesNaam = new TableColumn<Broodje, String>("Broodjesnaam");
        colBroodjesNaam.setMinWidth(300);
        colBroodjesNaam.setCellValueFactory(new PropertyValueFactory<Broodje, String>("broodjesNaam"));
        TableColumn<Broodje, Double> colBroodjesPrijs = new TableColumn<Broodje, Double>("Broodjesprijs");
        colBroodjesPrijs.setMinWidth(100);
        colBroodjesPrijs.setCellValueFactory(new PropertyValueFactory<Broodje, Double>("broodjesPrijs"));
        TableColumn<Broodje, Integer> colBroodjesStock = new TableColumn<Broodje, Integer>("Broodjesstock");
        colBroodjesStock.setMinWidth(100);
        colBroodjesStock.setCellValueFactory(new PropertyValueFactory<Broodje, Integer>("broodjesStock"));
        table.getColumns().addAll(colBroodjesNaam,colBroodjesPrijs,colBroodjesStock);

        root.getChildren().addAll(lblHeading, table);

        this.getChildren().addAll(root);
    }
}
