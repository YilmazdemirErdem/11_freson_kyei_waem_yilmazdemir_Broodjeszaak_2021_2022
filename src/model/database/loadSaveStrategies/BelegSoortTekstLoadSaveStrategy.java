package model.database.loadSaveStrategies;

import model.BelegSoort;
import utilities.TekstLoadSaveTemplate;

public class BelegSoortTekstLoadSaveStrategy extends TekstLoadSaveTemplate implements LoadSaveStrategy {

    public BelegSoortTekstLoadSaveStrategy() {}

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
    public String maakTekstLijn(Object object) {
        String outputLijn = "";
        BelegSoort belegSoort = ((BelegSoort) object);
        outputLijn = belegSoort.getBelegNaam() + "," + belegSoort.getBelegPrijs() + ","
                + belegSoort.getBelegStock() + "," + belegSoort.getAantalBelegVerkocht();
        return outputLijn;
    }
}
