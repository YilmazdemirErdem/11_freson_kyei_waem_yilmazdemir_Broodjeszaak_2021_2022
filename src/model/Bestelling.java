package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Bestelling {
    private HashMap<Broodje, ArrayList<BelegSoort>> bestellijnen;

    public Bestelling(){
        bestellijnen = new HashMap<Broodje, ArrayList<BelegSoort>>();
    }

    public HashMap<Broodje, ArrayList<BelegSoort>> getBestellijnen() {
        return bestellijnen;
    }

    public void setBestellijnen(HashMap<Broodje, ArrayList<BelegSoort>> bestellijnen) {
        this.bestellijnen = bestellijnen;
    }

    public void toevoegenBroodje(Broodje broodje){
        bestellijnen.put(broodje, new ArrayList<BelegSoort>());
    }
}
