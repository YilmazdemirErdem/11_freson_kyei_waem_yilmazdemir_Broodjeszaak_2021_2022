package model.database.loadSaveStrategies;

import model.Broodje;
import utilities.ExcelLoadSaveTemplate;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class BroodjesExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy{

    public BroodjesExcelLoadSaveStrategy() {}

    @Override
    public Object maakObject(String[] tokens) {
        String broodjesNaam = tokens[0];
        double broodjesPrijs = Double.parseDouble(tokens[1]);
        int broodjeStock = Integer.parseInt(tokens[2]);
        int aantalBroodjesVerkocht = Integer.parseInt(tokens[3]);
        return new Broodje(broodjesNaam, broodjesPrijs, broodjeStock, aantalBroodjesVerkocht);
    }

    @Override
    public Object getKey(String[] tokens) {
        return tokens[0];
    }
}
