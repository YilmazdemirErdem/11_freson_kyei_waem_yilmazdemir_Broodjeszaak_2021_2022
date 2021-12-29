package model.bestelStates;

import model.BelegSoort;
import model.Bestellijn;
import model.Bestelling;
import model.Broodje;

public interface BestellingState {

    void maakNieuweBestelling();

    void voegBestellijnToe(Broodje broodje);

    void verwijderBroodje(Bestellijn bestellijn);

    void voegIdentiekBroodjeToe(Bestellijn bestellijn);

    void voegBelegToe(Bestellijn bestellijn, BelegSoort belegSoort);

    double afsluiten(String kortingsStrategie);

    void annuleren(Bestelling bestelling);

    void betalen();

    void startBereiding();

    void naar_keuken();

    void afgewerkt();

}
