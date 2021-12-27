package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Bestelling {
    private HashMap<Broodje, ArrayList<BelegSoort>> bestellijnen;

    public Bestelling(HashMap<Broodje, ArrayList<BelegSoort>> bestellijnen) {
        setBestellijnen(bestellijnen);
    }

    public HashMap<Broodje, ArrayList<BelegSoort>> getBestellijnen() {
        return bestellijnen;
    }

    public void setBestellijnen(HashMap<Broodje, ArrayList<BelegSoort>> bestellijnen) {
        this.bestellijnen = bestellijnen;
    }

    public void toevoegenBroodje(Broodje broodje){
        bestellijnen.put(broodje, null);
    }
}
