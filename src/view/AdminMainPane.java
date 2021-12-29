package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import model.database.BelegDatabase;
import model.database.BroodjesDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import view.panels.AdminInstellingenPane;
import view.panels.BroodjesBelegOverviewPane;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class AdminMainPane extends BorderPane {

    public AdminMainPane() {
        BroodjesDatabase broodjesDatabase = new BroodjesDatabase(LoadSaveStrategyEnum.EXCEL);
        BelegDatabase belegDatabase = new BelegDatabase(LoadSaveStrategyEnum.TEKST);

        TabPane tabPane = new TabPane();
        BroodjesBelegOverviewPane broodjesBelegOverviewPane = new BroodjesBelegOverviewPane(broodjesDatabase, belegDatabase);
        AdminInstellingenPane adminInstellingenPane = new AdminInstellingenPane(broodjesDatabase, belegDatabase);
        Tab broodjesTab = new Tab("Broodjes/Beleg", broodjesBelegOverviewPane);
        Tab instellingTab = new Tab("Instellingen", adminInstellingenPane);
        Tab statistiekTab = new Tab("Statistieken");
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
    }
}

