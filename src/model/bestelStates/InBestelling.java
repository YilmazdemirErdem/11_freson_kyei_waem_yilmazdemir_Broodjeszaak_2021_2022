package model.bestelStates;

import model.*;
import model.kortingStrategies.KortingStrategyEnum;
import model.kortingStrategies.KortingStrategyFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class InBestelling implements BestellingState {
    private Bestelling bestelling;

    public InBestelling(Bestelling bestelling) {
        this.bestelling = bestelling;
    }

    @Override
    public void maakNieuweBestelling() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void voegBestellijnToe(Broodje broodje) {
        bestelling.getBestellijnen().add(new Bestellijn(broodje));
    }

    @Override
    public void verwijderBroodje(Bestellijn bestellijn) {
        bestellijn.getBroodje().aanpassenVoorraad(1);
        for (BelegSoort belegSoort: bestellijn.getBelegSoort()){
            belegSoort.aanpassenVoorraad(1);
        }
        bestelling.getBestellijnen().remove(bestellijn);
    }

    @Override
    public void voegIdentiekBroodjeToe(Bestellijn bestellijn) {
        Bestellijn bestellijnCopy = new Bestellijn(bestellijn.getBroodje());
        for (BelegSoort belegSoort:bestellijn.getBelegSoort()) {
            bestellijnCopy.voegBelegToe(belegSoort);
        }
        bestelling.getBestellijnen().add(bestellijnCopy);
    }

    @Override
    public void voegBelegToe(Bestellijn bestellijn, BelegSoort belegSoort) {
        bestellijn.voegBelegToe(belegSoort);
    }

    @Override
    public double afsluiten(String kortingsStrategie) {
        double totalePrijs = 0;
        for (Bestellijn bestellijn:bestelling.getBestellijnen()) {
            totalePrijs += bestellijn.getPrijsBestellijn();
        }
        if (kortingsStrategie == null){
            BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
            bestelling.setState(bestelling.getAfgesloten());
            return bd.doubleValue();
        }
        KortingStrategyFactory kortingStrategyFactory = KortingStrategyFactory.getInstance();
        for (KortingStrategyEnum kortingsEnum: KortingStrategyEnum.values()) {
            if (kortingsEnum.getStringValue().equals(kortingsStrategie)){
                totalePrijs = kortingStrategyFactory.createKortingStrategy(kortingsEnum).pasKortingToe(totalePrijs, bestelling.getBestellijnen());
            }
        }
        BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
        bestelling.setState(bestelling.getAfgesloten());
        return bd.doubleValue();
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
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void startBereiding() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void naar_keuken(ArrayList<Bestelling> wachtrij, Bestelling bestelling) {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void afgewerkt() {
        throw new IllegalArgumentException("you can't do this function");
    }
}
