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

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BestelView {
    private Stage stage = new Stage();
    private Label aantal_bestellingen = new Label("Volgnr: 0");
    private Label aantal_broodjes = new Label("Aantal Broodjes: 0");
    private Label te_betalen = new Label("Te betalen: 0");
    private Button nieuwe_bestelling_button;
    private ChoiceBox<String> kortingKeuze;
    private Button voeg_zelfde_broodje_toe_button;
    private Button verwijder_broodje_button;
    private Button annuleer_bestelling_button;
    private Button afsluiten_bestelling_button;
    private Button betaal_button;
    private Button naar_keuken_button;
    private TableView bestellijnen;
    private ListView listBroodjes;
    private ListView listBeleg;
    private ObservableList<BelegSoort> observableListBeleg;
    private ObservableList<Broodje> observableListBroodjes;
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
        nieuwe_bestelling_button = new Button("Nieuwe Bestelling");
        one_one.getChildren().addAll(nieuwe_bestelling_button, aantal_bestellingen);
        nieuwe_bestelling_button.setOnAction(event -> controller.nieuweBestellingButtonPressed());

        HBox one = new HBox(8);
        one.setSpacing(125);
        kortingKeuze = new ChoiceBox<>();
        kortingKeuze.getItems().addAll("Geen korting", "10% korting op ganse bestelling", "Goedkoopste broodje met beleg gratis");
        kortingKeuze.setDisable(true);
        one.getChildren().addAll(one_one, kortingKeuze);

        HBox two_one = new HBox(8);
        listBroodjes = new ListView();
        two_one.getChildren().addAll(listBroodjes);

        HBox two_two = new HBox(8);
        listBeleg = new ListView();
        two_two.getChildren().addAll(listBeleg);

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
        colBelegNaam.setMinWidth(250);
        colBelegNaam.setCellValueFactory(new PropertyValueFactory<BelegSoort, ArrayList<String>>("namenBeleg"));
        bestellijnen.getColumns().addAll(colBroodjesNaam,colBelegNaam);
        four_one.getChildren().addAll(bestellijnen);

        VBox four_two_one = new VBox(8);
        four_two_one.setPadding(new Insets(10));
        four_two_one.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        voeg_zelfde_broodje_toe_button = new Button("Voeg zelfde broodje toe");
        voeg_zelfde_broodje_toe_button.setDisable(true);
        voeg_zelfde_broodje_toe_button.setOnAction(event -> controller.voegZelfdeBroodjeToeButtonPressed());
        verwijder_broodje_button = new Button("Verwijder broodje");
        verwijder_broodje_button.setDisable(true);
        verwijder_broodje_button.setOnAction(event -> controller.VerwijderBroodjeButtonPressed());
        four_two_one.getChildren().addAll(voeg_zelfde_broodje_toe_button, verwijder_broodje_button);

        VBox four_two = new VBox(8);
        four_two.setSpacing(50);
        annuleer_bestelling_button = new Button("Annuleer bestelling");
        annuleer_bestelling_button.setDisable(true);
        annuleer_bestelling_button.setOnAction(event -> controller.annuleerBestelling());
        four_two.getChildren().addAll(four_two_one, annuleer_bestelling_button);

        HBox four = new HBox(8);
        four.setSpacing(10);
        four.getChildren().addAll(four_one, four_two);

        HBox five_one = new HBox(8);
        afsluiten_bestelling_button = new Button("afsluiten bestelling");
        afsluiten_bestelling_button.setDisable(true);
        afsluiten_bestelling_button.setOnAction(event -> controller.afsluitenBetalingButtonPressed());
        five_one.getChildren().addAll(afsluiten_bestelling_button, te_betalen);

        HBox five_two = new HBox(8);
        betaal_button = new Button("Betaal");
        betaal_button.setDisable(true);
        betaal_button.setOnAction(event -> controller.betaalBestelling());
        naar_keuken_button = new Button("Naar Keuken");
        naar_keuken_button.setDisable(true);
        naar_keuken_button.setOnAction(event -> controller.zendNaarKeukenBestelling(bestellijnen.getItems()));
        five_two.getChildren().addAll(betaal_button, naar_keuken_button);

        HBox five = new HBox(8);
        five.setSpacing(100);
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

    public void updateBroodjesStatusKnoppen(BestelViewController controller){
        observableListBroodjes = FXCollections.observableArrayList(controller.getOpVoorraadLijstBroodjes());
        listBroodjes.getItems().clear();
        for (Broodje broodje: observableListBroodjes) {
            Button button = new Button(broodje.getBroodjesNaam());
            listBroodjes.getItems().add(button);
            button.setOnAction(event -> controller.broodjeButtonPressed(broodje));
        }
        listBroodjes.refresh();
    }

    public void updateBelegStatusKnoppen(BestelViewController controller){
        observableListBeleg = FXCollections.observableArrayList(controller.getOpVoorraadLijstBelegSoorten());
        listBeleg.getItems().clear();
        for (BelegSoort belegSoort: observableListBeleg) {
            Button button = new Button(belegSoort.getBelegNaam());
            listBeleg.getItems().add(button);
            button.setOnAction(event -> controller.belegButtonPressed(belegSoort));
        }
        listBroodjes.refresh();
    }

    public void updateStatusInWachtKnoppen(Boolean status){
        listBroodjes.setDisable(!status);
        listBeleg.setDisable(!status);
        nieuwe_bestelling_button.setDisable(status);
        kortingKeuze.setDisable(!status);
        verwijder_broodje_button.setDisable(!status);
        voeg_zelfde_broodje_toe_button.setDisable(!status);
        annuleer_bestelling_button.setDisable(!status);
        afsluiten_bestelling_button.setDisable(!status);
        betaal_button.setDisable(!status);
        naar_keuken_button.setDisable(!status);
    }

    public void updateStatusInBestellingKnoppen(Boolean status){
        listBroodjes.setDisable(status);
        listBeleg.setDisable(status);
        nieuwe_bestelling_button.setDisable(!status);
        kortingKeuze.setDisable(status);
        verwijder_broodje_button.setDisable(status);
        voeg_zelfde_broodje_toe_button.setDisable(status);
        annuleer_bestelling_button.setDisable(status);
        afsluiten_bestelling_button.setDisable(status);
        betaal_button.setDisable(!status);
        naar_keuken_button.setDisable(!status);
    }

    public void updateStatusInAfgeslotenKnoppen(Boolean status){
        listBroodjes.setDisable(!status);
        listBeleg.setDisable(!status);
        nieuwe_bestelling_button.setDisable(!status);
        kortingKeuze.setDisable(!status);
        verwijder_broodje_button.setDisable(!status);
        voeg_zelfde_broodje_toe_button.setDisable(!status);
        annuleer_bestelling_button.setDisable(status);
        afsluiten_bestelling_button.setDisable(!status);
        betaal_button.setDisable(status);
        naar_keuken_button.setDisable(!status);
    };

    public void updateStatusInBetaaldKnoppen(Boolean status){
        listBroodjes.setDisable(!status);
        listBeleg.setDisable(!status);
        nieuwe_bestelling_button.setDisable(!status);
        kortingKeuze.setDisable(!status);
        verwijder_broodje_button.setDisable(!status);
        voeg_zelfde_broodje_toe_button.setDisable(!status);
        annuleer_bestelling_button.setDisable(!status);
        afsluiten_bestelling_button.setDisable(!status);
        betaal_button.setDisable(!status);
        naar_keuken_button.setDisable(status);
    }

    public Bestellijn getSelectedBestellijn() {
        Bestellijn bestellijn = (Bestellijn) bestellijnen.getSelectionModel().getSelectedItem();
        return bestellijn;
    }

    public String getkortingsStrategie() {
        return kortingKeuze.getValue();
    }

    public int getAantalBroodjes(){
        int aantalBroodjes = 0;
        aantalBroodjes = Integer.parseInt((String) Array.get(aantal_broodjes.getText().split(" "), 2));
        return aantalBroodjes;
    }

    public void foutMelding(String header, String content){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(header);
        alert.setContentText(content);

        alert.showAndWait();
    }
}
