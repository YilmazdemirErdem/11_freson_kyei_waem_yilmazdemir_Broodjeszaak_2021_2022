package view;

import controller.BestelViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.BelegSoort;
import model.Bestellijn;
import model.Broodje;
import model.database.BroodjesDatabase;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;


public class BestelView {
    private Stage stage = new Stage();
    private Label aantal_bestellingen = new Label("Volgnr: 0");
    private Label aantal_broodjes = new Label("Aantal Broodjes: 0");
    private Label te_betalen = new Label("Te betalen: 0");
    private TableView bestellijnen;
    private ChoiceBox<String> kortingKeuze;
    private ObservableList<Bestellijn> observableListBestellijnen;

    public BestelView(BestelViewController controller){
        stage.setTitle("ORDER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(20);
        stage.setY(20);
        Pane root = createNodeHierarchy(controller);
        Scene scene = new Scene(root, 650, 650);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        controller.setView(this);
    }

    public void setLabelAantalBestellingen(String s) {
        aantal_bestellingen.setText(s);
    }

    public void setLabelAantalBroodjes(String s){
        aantal_broodjes.setText(s);
    }

    public void setLabelTeBetalen(String s){
        te_betalen.setText(s);
    }

    private Pane createNodeHierarchy(BestelViewController controller) {

        HBox one_one = new HBox(8);
        Button nieuwe_bestelling_button = new Button("Nieuwe Bestelling");
        one_one.getChildren().addAll(nieuwe_bestelling_button, aantal_bestellingen);
        nieuwe_bestelling_button.setOnAction(event -> controller.nieuweBestellingButtonPressed());

        HBox one = new HBox(8);
        one.setSpacing(300);
        kortingKeuze = new ChoiceBox<>();
        kortingKeuze.getItems().addAll("Geen korting", "10% korting op ganse bestelling", "Goedkoopste broodje met beleg gratis");
        one.getChildren().addAll(one_one, kortingKeuze);

        HBox two_one = new HBox(8);
        for (Broodje broodje: controller.getOpVoorraadLijstBroodjes()) {
            Button button = new Button(broodje.getBroodjesNaam());
            two_one.getChildren().addAll(button);
            button.setOnAction(event -> controller.broodjeButtonPressed(broodje));
        }

        HBox two_two = new HBox(8);
        for (BelegSoort belegSoort: controller.getOpVoorraadLijstBelegSoorten()) {
            Button button = new Button(belegSoort.getBelegNaam());
            two_two.getChildren().addAll(button);
            button.setOnAction(event -> controller.belegButtonPressed(belegSoort));
        }

        VBox two = new VBox(8);
        two.setPadding(new Insets(10));
        two.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        two.getChildren().addAll(two_one, two_two);

        HBox three = new HBox(8);
        three.getChildren().addAll(aantal_broodjes);

        HBox four_one = new HBox(8);
        bestellijnen = new TableView();
        TableColumn<Bestellijn, String> colBroodjesNaam = new TableColumn<Bestellijn, String>("Broodjes");
        colBroodjesNaam.setMinWidth(100);
        colBroodjesNaam.setCellValueFactory(new PropertyValueFactory<Bestellijn, String>("naamBroodje"));
        TableColumn<BelegSoort, ArrayList<String>> colBelegNaam = new TableColumn<BelegSoort, ArrayList<String>>("Beleg");
        colBelegNaam.setMinWidth(350);
        colBelegNaam.setCellValueFactory(new PropertyValueFactory<BelegSoort, ArrayList<String>>("namenBeleg"));
        bestellijnen.getColumns().addAll(colBroodjesNaam,colBelegNaam);
        four_one.getChildren().addAll(bestellijnen);

        VBox four_two_one = new VBox(8);
        four_two_one.setPadding(new Insets(10));
        four_two_one.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        Button voeg_zelfde_broodje_toe_button = new Button("Voeg zelfde broodje toe");
        voeg_zelfde_broodje_toe_button.setOnAction(event -> controller.voegZelfdeBroodjeToeButtonPressed());

        Button verwijder_broodje_button = new Button("Verwijder broodje");
        verwijder_broodje_button.setOnAction(event -> controller.VerwijderBroodjeButtonPressed());
        four_two_one.getChildren().addAll(voeg_zelfde_broodje_toe_button, verwijder_broodje_button);

        VBox four_two = new VBox(8);
        four_two.setSpacing(100);
        Button annuleer_bestelling_button = new Button("Annuleer bestelling");
        four_two.getChildren().addAll(four_two_one, annuleer_bestelling_button);

        HBox four = new HBox(8);
        four.setSpacing(10);
        four.getChildren().addAll(four_one, four_two);

        HBox five_one = new HBox(8);
        Button afsluiten_bestelling_button = new Button("afsluiten bestelling");
        afsluiten_bestelling_button.setOnAction(event -> controller.afsluitenBetalingButtonPressed());
        five_one.getChildren().addAll(afsluiten_bestelling_button, te_betalen);

        HBox five_two = new HBox(8);
        Button betaal_button = new Button("Betaal");
        Button naar_keuken_button = new Button("Naar Keuken");
        five_two.getChildren().addAll(betaal_button, naar_keuken_button);

        HBox five = new HBox(8);
        five.setSpacing(300);
        five.setPadding(new Insets(10));
        five.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        five.getChildren().addAll(five_one, five_two);

        VBox main = new VBox(8);
        main.setPadding(new Insets(10));
        main.getChildren().addAll(one, two, three, four, five);

        return main;
    }

    public void updateBestelijnen(BestelViewController controller){
        observableListBestellijnen = FXCollections.observableArrayList(controller.getLijstBestellijnen());
        bestellijnen.setItems(observableListBestellijnen);
        bestellijnen.refresh();
    }

    public void updateStatusBroodjesKnoppen(){};

    public Bestellijn getSelectedBestellijn() {
        Bestellijn bestellijn = (Bestellijn) bestellijnen.getSelectionModel().getSelectedItem();
        return bestellijn;
    }

    public String getkortingsStrategie() {
        return kortingKeuze.getValue();
    }

    public void foutMelding(String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
