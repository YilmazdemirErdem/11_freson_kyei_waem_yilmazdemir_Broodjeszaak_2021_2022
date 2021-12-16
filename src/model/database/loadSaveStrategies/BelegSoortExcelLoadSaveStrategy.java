package model.database.loadSaveStrategies;

import model.BelegSoort;
import model.Broodje;
import utilities.ExcelLoadSaveTemplate;

import java.util.ArrayList;

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

    @Override
    public ArrayList<String> maaktTekstLijn(Object object) {
        ArrayList<String> outputLijn = new ArrayList<>();
        BelegSoort belegSoort = ((BelegSoort) object);
        outputLijn.add(belegSoort.getBelegNaam());
        outputLijn.add(Double.toString(belegSoort.getBelegPrijs()));
        outputLijn.add(Integer.toString(belegSoort.getBelegStock()));
        outputLijn.add(Integer.toString(belegSoort.getAantalBelegVerkocht()));
        return outputLijn;
    }
}

