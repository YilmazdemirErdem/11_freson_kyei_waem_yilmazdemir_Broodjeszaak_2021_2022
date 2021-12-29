package view;

import controller.KeukenViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.BelegSoort;
import model.Bestellijn;
import model.Bestelling;

import java.util.ArrayList;

public class KeukenView {

    private Stage stage = new Stage();
    private Label aantal_bestellingen_in_wachtrij = new Label("Aantal bestellingen in de wachtrij: 0");
    private Label volgnr = new Label("Volgnummer bestelling: 0");
    private Label streepje = new Label("–");
    private Label aantal_broodjes = new Label("Aantal Broodjes: 0");
    private TableView bestellijnen;
    private ObservableList<Bestellijn> observableListBestellijnen;

    public KeukenView(KeukenViewController controller){
        stage.setTitle("KITCHEN VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(680);
        stage.setY(470);
        Pane root = createNodeHierarchy(controller);
        Scene scene = new Scene(root, 650, 200);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        controller.setView(this);
    }
    private Pane createNodeHierarchy(KeukenViewController controller) {
        VBox one = new VBox(8);
        one.getChildren().addAll(aantal_bestellingen_in_wachtrij);

        HBox two = new HBox(8);
        two.getChildren().addAll(volgnr);
        two.getChildren().addAll(streepje);
        two.getChildren().addAll(aantal_broodjes);


        HBox buttonBox = new HBox(8);

        //TODO: Deze knoppen zijn alleen actief als er nog bestellingen in de wachtrij zitten.
        Button volgendeKnop = new Button("Volgende bestelling");
        volgendeKnop.setOnAction(event -> controller.volgendeKnopPressed());
        volgendeKnop.setDisable(false);
        Button afgewerktKnop = new Button("Bestelling afgewerkt");
        afgewerktKnop.setOnAction(event -> controller.afgewerktKnopPressed());
        afgewerktKnop.setDisable(true);

        buttonBox.getChildren().addAll(volgendeKnop);
        buttonBox.getChildren().addAll(afgewerktKnop);

        HBox four = new HBox(8);
        bestellijnen = new TableView();
        TableColumn<Bestellijn, String> colBroodjesNaam = new TableColumn<Bestellijn, String>("Broodjes");
        colBroodjesNaam.setMinWidth(100);
        colBroodjesNaam.setCellValueFactory(new PropertyValueFactory<Bestellijn, String>("naamBroodje"));
        TableColumn<BelegSoort, ArrayList<String>> colBelegNaam = new TableColumn<BelegSoort, ArrayList<String>>("Beleg");
        colBelegNaam.setMinWidth(250);
        colBelegNaam.setCellValueFactory(new PropertyValueFactory<BelegSoort, ArrayList<String>>("namenBeleg"));
        bestellijnen.getColumns().addAll(colBroodjesNaam,colBelegNaam);
        four.getChildren().addAll(bestellijnen);


        VBox main = new VBox(8);
        main.setPadding(new Insets(10));
        main.getChildren().addAll(one, two, buttonBox, four);

        return main;
    }

    public void updateBestellijnen(KeukenViewController controller){
        ArrayList<Bestellijn> arrayList = controller.getLijstBestellijnen();
        observableListBestellijnen = FXCollections.observableArrayList(arrayList);
        bestellijnen.setItems(observableListBestellijnen);
        bestellijnen.refresh();
    }

    public void setLabelAantalBestellingenInWachtrij(String s){
        aantal_bestellingen_in_wachtrij.setText(s);
    }

    public void setLabelVolgnr(String s){
        volgnr.setText(s);
    }

    public void setLabelAantalBroodjes(String s){
        aantal_broodjes.setText(s);
    }
}