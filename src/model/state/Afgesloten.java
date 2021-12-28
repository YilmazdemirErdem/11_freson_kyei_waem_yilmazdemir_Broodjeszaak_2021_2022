package model.state;

import model.*;

public class Afgesloten implements BestellingState {
    private Bestelling bestelling;

    public Afgesloten(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void maakNieuweBestelling() {
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
    public void annuleren() {
        bestelling.setState(bestelling.getInWacht());
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
    public void naar_keuken() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void afgewerkt() {
        throw new IllegalArgumentException("you can't do this function");
    }
}
