package model.database;

import model.BelegSoort;
import model.Broodje;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.database.loadSaveStrategies.LoadSaveStrategyFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class BelegDatabase {
    private TreeMap belegMap;

    public BelegDatabase(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        setBelegMap(loadSaveStrategyEnum);
    }

    public void setBelegMap(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        File file = new File("src/bestanden/beleg.txt");
        File file2 = new File("src/bestanden/beleg.xls");
        LoadSaveStrategyFactory loadSaveStrategyFactory = LoadSaveStrategyFactory.getInstance();
        if (loadSaveStrategyEnum == LoadSaveStrategyEnum.EXCEL){
            this.belegMap = loadSaveStrategyFactory.createBelegSoortLoadSaveStrategy(loadSaveStrategyEnum).load(file2);
        } else {
            this.belegMap = loadSaveStrategyFactory.createBelegSoortLoadSaveStrategy(loadSaveStrategyEnum).load(file);
        }
    }

    public List<BelegSoort> belegSoortMapToList(){
        return new ArrayList<>(this.belegMap.values());
    }

    public ArrayList<BelegSoort> getOpVoorraadLijstBelegSoorten() {
        ArrayList<BelegSoort> opVoorraadBelegSoorten = new ArrayList<>();
        for (BelegSoort belegSoort : belegSoortMapToList()) {
            if (belegSoort.getBelegStock() > 0){
                opVoorraadBelegSoorten.add(belegSoort);
            }
        }
        return opVoorraadBelegSoorten;
    }
}

