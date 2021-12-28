package model;

import model.kortingStrategies.KortingStrategy;
import model.kortingStrategies.KortingStrategyEnum;
import model.kortingStrategies.KortingStrategyFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        bestelling.getBestellijnen().remove(bestellijn);
    }

    @Override
    public void voegIdentiekBroodjeToe(Bestellijn bestellijn) {
        bestelling.getBestellijnen().add(bestellijn);
    }

    @Override
    public void voegBelegToe(Bestellijn bestellijn, BelegSoort belegSoort) {
        bestellijn.voegBelegToe(belegSoort);
    }

    @Override
    public double afsluiten(String kortingsStrategie) {
        KortingStrategyEnum kortingStrategyEnum = KortingStrategyEnum.valueOf(kortingsStrategie);
        KortingStrategyFactory kortingStrategyFactory = KortingStrategyFactory.getInstance();

        double totalePrijs = 0;
        for (Bestellijn bestellijn:bestelling.getBestellijnen()) {
            totalePrijs += bestellijn.getPrijsBestellijn();
        }

        if (kortingsStrategie == null){
            BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }
        if (kortingStrategyEnum == KortingStrategyEnum.TIEN_PROCENT_OP_GANSE_BESTELLING){

        }else{

        }

        /*double totalePrijs = 0;
        for (Bestellijn bestellijn:bestelling.getBestellijnen()) {
            totalePrijs += bestellijn.getPrijsBestellijn();
        }

        if (kortingsStrategie == null){
            BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }*/
        if (kortingsStrategie.equals("10% korting op ganse bestelling")){
            totalePrijs -= totalePrijs*0.1;
        }else if(kortingsStrategie.equals("Goedkoopste broodje met beleg gratis")){
            double goedkoopste = Double.MAX_VALUE;
            for (Bestellijn bestellijn: bestelling.getBestellijnen()) {
                if (bestellijn.getPrijsBestellijn() < goedkoopste){
                    goedkoopste = bestellijn.getPrijsBestellijn();
                }
            }
            totalePrijs -= goedkoopste;
        }

        BigDecimal bd = new BigDecimal(totalePrijs).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public void annuleren() {
        bestelling.setState(bestelling.getInWacht());
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
    public void naar_keuken() {
        throw new IllegalArgumentException("you can't do this function");
    }

    @Override
    public void afgewerkt() {
        throw new IllegalArgumentException("you can't do this function");
    }
}
