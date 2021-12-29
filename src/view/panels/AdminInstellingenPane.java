package view.panels;

import controller.BestelViewController;
import controller.BroodjesViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;

import javax.swing.*;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class AdminInstellingenPane extends GridPane {

    public AdminInstellingenPane(BroodjesDatabase broodjesDatabase, BelegDatabase belegDatabase) {

        VBox one = new VBox(8);
        Label huidigeFormaatLabel = new Label("Huidige gegevens Formaat: xxx");
        Label formaatLabel = new Label("Gegevens Formaat");

        ChoiceBox<String> formaatKeuze = new ChoiceBox<>();
        formaatKeuze.getItems().addAll("Excel", "Tekst");
        one.getChildren().addAll(huidigeFormaatLabel, formaatLabel, formaatKeuze);


        VBox two = new VBox(8);
        Label huidigeKortingStrategieLabel = new Label("Huidige korting strategie: xxx");
        Label kortingStrategieLabel = new Label("Korting Strategie");

        ChoiceBox<String> kortingKeuze = new ChoiceBox<>();
        kortingKeuze.getItems().addAll("Geen korting", "10% korting op ganse bestelling", "Goedkoopste broodje met beleg gratis");

        two.getChildren().addAll(huidigeKortingStrategieLabel);
        two.getChildren().addAll(kortingStrategieLabel);
        two.getChildren().addAll(kortingKeuze);


        VBox buttonBox = new VBox();
        Button buttonSave = new Button("Save");
        buttonBox.getChildren().add(buttonSave);

        /*this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);*/

        VBox root = new VBox(8);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(one, two, buttonBox);

        this.getChildren().addAll(root);
    }

}