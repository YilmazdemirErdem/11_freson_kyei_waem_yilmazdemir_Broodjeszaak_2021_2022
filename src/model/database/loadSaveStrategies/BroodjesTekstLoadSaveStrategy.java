package model.database.loadSaveStrategies;

import model.Broodje;
import utilities.TekstLoadSaveTemplate;

public class BroodjesTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy {

    public BroodjesTekstLoadSaveStrategy() {}

    @Override
    public Broodje maakObject(String[] tokens){
        String broodjesNaam = tokens[0];
        double broodjesPrijs = Double.parseDouble(tokens[1]);
        int broodjeStock = Integer.parseInt(tokens[2]);
        int aantalBroodjesVerkocht = Integer.parseInt(tokens[3]);
        return new Broodje(broodjesNaam, broodjesPrijs, broodjeStock, aantalBroodjesVerkocht);
    }

    @Override
    public String getKey(String[] tokens){
        return tokens[0];
    }

}
