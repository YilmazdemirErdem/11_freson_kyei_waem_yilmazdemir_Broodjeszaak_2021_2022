package model.bestelStates;

import model.*;
import model.database.BroodjesDatabase;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class Betaald implements BestellingState {

    private Bestelling bestelling;

    public Betaald(Bestelling bestelling) {
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
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void betalen() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void startBereiding() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void naar_keuken(ArrayList<Bestelling> wachtrij, Bestelling bestelling, BroodjesDatabase broodjesDatabase) {
        bestelling.setState(bestelling.getInWachtrij());
        wachtrij.add(bestelling);
        /*broodjesDatabase.save(LoadSaveStrategyEnum.TEKST);*/
    }

    @Override
    public void afgewerkt() {
        throw new IllegalArgumentException("you can't do this function");
    }
}
