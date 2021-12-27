package model.database;

import model.Broodje;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson
 */

public class BroodjesDatabase {
    private TreeMap broodjesMap;

    public BroodjesDatabase(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        setBroodjesMap(loadSaveStrategyEnum);
    }

    public void setBroodjesMap(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        File file = new File("src/bestanden/broodjes.txt");
        File file2 = new File("src/bestanden/broodjes.xls");
        LoadSaveStrategyFactory loadSaveStrategyFactory = LoadSaveStrategyFactory.getInstance();
        if (loadSaveStrategyEnum == LoadSaveStrategyEnum.EXCEL){
            this.broodjesMap = loadSaveStrategyFactory.createBroodjesLoadSaveStrategy(loadSaveStrategyEnum).load(file2);
        } else {
            this.broodjesMap = loadSaveStrategyFactory.createBroodjesLoadSaveStrategy(loadSaveStrategyEnum).load(file);
        }
    }

    public ArrayList<Broodje> broodjesMapToList(){
        return new ArrayList<>(this.broodjesMap.values());
    }

    public Broodje getBroodje(String broodjesNaam) {
        return (Broodje) this.broodjesMap.get(broodjesNaam);
    }

    public ArrayList<Broodje> getOpVoorraadLijstBroodjes() {
        ArrayList<Broodje> opVoorraadBroodjes = new ArrayList<>();
        for (Broodje broodje : broodjesMapToList()) {
            if (broodje.getBroodjesStock() != 0){
                opVoorraadBroodjes.add(broodje);
            }
        }
        return opVoorraadBroodjes;
    }
}
