package view.panels;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BroodjesBelegOverviewPane extends GridPane{
    private BroodjesDatabase broodjesDatabase;
    private BelegDatabase belegDatabase;
    private BroodjesPane broodjesPane;
    private BelegPane belegPane;

    public BroodjesBelegOverviewPane(BroodjesDatabase broodjesDatabase, BelegDatabase belegDatabase) {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        this.broodjesDatabase = broodjesDatabase;
        this.belegDatabase = belegDatabase;

        broodjesPane = new BroodjesPane(broodjesDatabase);
        belegPane = new BelegPane(belegDatabase);
        this.getChildren().addAll(broodjesPane, belegPane);
    }

    public void refresh(){
        broodjesPane.refresh(broodjesDatabase);
        belegPane.refresh(belegDatabase);
    }
}