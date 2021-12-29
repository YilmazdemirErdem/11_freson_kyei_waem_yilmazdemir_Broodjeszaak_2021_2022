package model.bestelStates;

import model.*;
import model.database.BroodjesDatabase;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class Afgesloten implements BestellingState {
    private Bestelling bestelling;

    public Afgesloten(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void maakNieuweBestelling(Bestelling bestelling) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void voegBestellijnToe(Broodje broodje) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void verwijderBroodje(Bestellijn bestellijn) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void voegIdentiekBroodjeToe(Bestellijn bestellijn) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void voegBelegToe(Bestellijn bestellijn, BelegSoort belegSoort) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public double afsluiten(String kortingsStrategie) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void annuleren(Bestelling bestelling) {
        for (Bestellijn bestellijn: bestelling.getBestellijnen()) {
            bestellijn.getBroodje().aanpassenVoorraad(1);
            for (BelegSoort belegSoort: bestellijn.getBelegSoort()){
                belegSoort.aanpassenVoorraad(1);
            }
        }
        bestelling.getBestellijnen().clear();
        this.bestelling.setState(this.bestelling.getInWacht());
    }

    @Override
    public void betalen() {
        bestelling.setState(bestelling.getBetaald());
    }

    @Override
    public void startBereiding() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void naar_keuken(ArrayList<Bestelling> wachtrij, Bestelling bestelling, BroodjesDatabase broodjesDatabase) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void afgewerkt() {
        throw new IllegalArgumentException("you can't do this function");
    }
}
