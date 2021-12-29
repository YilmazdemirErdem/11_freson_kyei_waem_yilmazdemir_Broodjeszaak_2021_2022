package model.bestelStates;

import model.BelegSoort;
import model.Bestellijn;
import model.Bestelling;
import model.Broodje;
import model.database.BroodjesDatabase;

import java.util.ArrayList;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public interface BestellingState {

    void maakNieuweBestelling(Bestelling bestelling);

    void voegBestellijnToe(Broodje broodje);

    void verwijderBroodje(Bestellijn bestellijn);

    void voegIdentiekBroodjeToe(Bestellijn bestellijn);

    void voegBelegToe(Bestellijn bestellijn, BelegSoort belegSoort);

    double afsluiten(String kortingsStrategie);

    void annuleren(Bestelling bestelling);

    void betalen();

    void startBereiding();

    void naar_keuken(ArrayList<Bestelling> wachtrij, Bestelling bestelling, BroodjesDatabase broodjesDatabase);

    void afgewerkt();

}
