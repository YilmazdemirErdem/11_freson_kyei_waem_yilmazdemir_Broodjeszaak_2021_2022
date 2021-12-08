package view.panels;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import model.database.BroodjesDatabase;
import view.BroodjesView;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, lol
 */

public class SandwichOverviewPane extends GridPane{

    public SandwichOverviewPane(BroodjesDatabase broodjesDatabase) {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        BroodjesView broodjesView = new BroodjesView(broodjesDatabase);
        this.getChildren().addAll(broodjesView);
    }
}