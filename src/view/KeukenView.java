package view;

import controller.BestelViewController;
import controller.KeukenViewController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Bestellijn;
import model.database.BelegDatabase;
import view.panels.KitchenPane;

import java.util.ArrayList;

public class KeukenView {

    private Stage stage = new Stage();
    private Label aantal_bestellingen_in_wachtrij = new Label("Aantal bestellingen in de wachtrij: 0");
    private Label volgnr = new Label("Volgnummer bestelling: 0");
    private Label streepje = new Label("–");
    private Label aantal_broodjes = new Label("Aantal Broodjes: 0");

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

        VBox main = new VBox(8);
        main.setPadding(new Insets(10));
        main.getChildren().addAll(one, two);

        //TODO: Deze knoppen zijn alleen actief als er nog bestellingen in de wachtrij zitten.
        Button volgendeKnop = new Button("Volgende bestelling");
        volgendeKnop.setOnAction(event -> controller.volgendeKnopPressed());
        volgendeKnop.setDisable(true);
        Button afgewerktKnop = new Button("Bestelling afgewerkt");
        afgewerktKnop.setOnAction(event -> controller.afgewerktKnopPressed());
        afgewerktKnop.setDisable(true);

        // dynamisch bestellijnen inladen
        ArrayList<Bestellijn> bestellijnen = controller.getLijstBestellijnen(); // [a, b, b, c, b, c] => [a, b, c, b, c]
        for (Bestellijn bestellijn : bestellijnen) {
            for (Bestellijn compare : bestellijnen) {
                if (bestellijn.getBroodje() == compare.getBroodje() && bestellijn.getNamenBeleg() == compare.getNamenBeleg()) {
                    bestellijnen.remove(bestellijn);
                    break;
                }
            }
        }

        //TODO ...

        return main;
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