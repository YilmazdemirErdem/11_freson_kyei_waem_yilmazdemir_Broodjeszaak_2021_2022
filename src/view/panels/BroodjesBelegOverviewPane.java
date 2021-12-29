package view.panels;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BroodjesBelegOverviewPane extends GridPane{

    public BroodjesBelegOverviewPane(BroodjesDatabase broodjesDatabase, BelegDatabase belegDatabase) {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        BroodjesPane broodjesPane = new BroodjesPane(broodjesDatabase);
        BelegPane belegPane = new BelegPane(belegDatabase);
        this.getChildren().addAll(broodjesPane, belegPane);
    }
}