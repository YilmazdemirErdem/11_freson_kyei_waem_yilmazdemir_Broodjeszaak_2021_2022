package view;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class BestelView {
    private Stage stage = new Stage();

    public BestelView(){
        stage.setTitle("ORDER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(20);
        stage.setY(20);
        Pane root = createNodeHierarchy();
        Scene scene = new Scene(root, 650, 650);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    private Pane createNodeHierarchy() {

        HBox one_one = new HBox(8);
        Button nieuwe_bestelling_button = new Button("Nieuwe Bestelling");
        Label volgnr = new Label("volgnr:");
        one_one.getChildren().addAll(nieuwe_bestelling_button, volgnr);

        HBox one = new HBox(8);
        one.setSpacing(400);
        ChoiceBox<String> kortingKeuze = new ChoiceBox<>();
        kortingKeuze.getItems().addAll("keuze 1", "keuze 2", "keuze 3");
        one.getChildren().addAll(one_one, kortingKeuze);

        HBox two_one = new HBox(8);
        Button mais_button = new Button("mais");
        Button volkoren_button = new Button("volkoren");
        Button wit_button = new Button("wit");
        two_one.getChildren().addAll(mais_button, volkoren_button, wit_button);

        HBox two_two = new HBox(8);
        Button feta_button = new Button("feta");
        Button hesp_button = new Button("hesp");
        Button kaas_button = new Button("kaas");
        Button komkommer_button = new Button("komkommer");
        Button olijven_button = new Button("olijven");
        Button sla_button = new Button("sla");
        Button tomaat_button = new Button("tomaat");
        two_two.getChildren().addAll(feta_button, hesp_button, kaas_button, komkommer_button, olijven_button, sla_button, tomaat_button);

        VBox two = new VBox(8);
        two.setPadding(new Insets(10));
        two.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        two.getChildren().addAll(two_one, two_two);

        HBox three = new HBox(8);
        Label aantal_broodjes = new Label("Aantal Broodjes");
        three.getChildren().addAll(aantal_broodjes);

        HBox four_one = new HBox(8);

        VBox four_two_one = new VBox(8);
        four_two_one.setPadding(new Insets(10));
        four_two_one.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(20), new Insets(0))));
        Button voeg_zelfde_broodje_toe_button = new Button("Voeg zelfde broodje toe");
        Button verwijder_broodje_button = new Button("Verwijder broodje");
        four_two_one.getChildren().addAll(voeg_zelfde_broodje_toe_button, verwijder_broodje_button);

        VBox four_two = new VBox(8);
        four_two.setSpacing(100);
        Button annuleer_bestelling_button = new Button("Annuleer bestelling");
        four_two.getChildren().addAll(four_two_one, annuleer_bestelling_button);

        HBox four = new HBox(8);
        four.setSpacing(400);
        four.getChildren().addAll(four_one, four_two);

        HBox five_one = new HBox(8);
        Button afsluiten_bestelling_button = new Button("afsluiten bestelling");
        Label te_betalen = new Label("Te Betalen: ");
        five_one.getChildren().addAll(afsluiten_bestelling_button);

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
}

