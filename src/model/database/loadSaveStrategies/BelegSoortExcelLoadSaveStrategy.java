package model.database.loadSaveStrategies;

import model.BelegSoort;
import utilities.ExcelLoadSaveTemplate;

public class BelegSoortExcelLoadSaveStrategy extends ExcelLoadSaveTemplate implements LoadSaveStrategy {

    public BelegSoortExcelLoadSaveStrategy() {}

    @Override
    public BelegSoort maakObject(String[] tokens){
        String belegNaam = tokens[0];
        double belegPrijs = Double.parseDouble(tokens[1]);
        int belegStock = Integer.parseInt(tokens[2]);
        int aantalBelegVerkocht = Integer.parseInt(tokens[3]);
        return new BelegSoort(belegNaam, belegPrijs, belegStock, aantalBelegVerkocht);
    }

    @Override
    public String getKey(String[] tokens){
        return tokens[0];
    }
}

