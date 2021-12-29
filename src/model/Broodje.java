package model;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class Broodje {
    private String broodjesNaam;
    private double broodjesPrijs;
    private int broodjesStock, aantalBroodjesVerkocht;

    public Broodje(){}

    public Broodje(String broodjesNaam, double broodjesPrijs, int broodjesStock, int aantalBroodjesVerkocht){
        setBroodjesNaam(broodjesNaam);
        setBroodjesPrijs(broodjesPrijs);
        setBroodjesStock(broodjesStock);
        setAantalBroodjesVerkocht(aantalBroodjesVerkocht);
    }

    public void setBroodjesNaam(String broodjesNaam) {
        this.broodjesNaam = broodjesNaam;
    }

    public void setBroodjesPrijs(double broodjesPrijs) {
        this.broodjesPrijs = broodjesPrijs;
    }

    public void setBroodjesStock(int broodjesStock) {
        this.broodjesStock = broodjesStock;
    }

    public void setAantalBroodjesVerkocht(int aantalBroodjesVerkocht) {
        this.aantalBroodjesVerkocht = aantalBroodjesVerkocht;
    }

    public String getBroodjesNaam() {
        return broodjesNaam;
    }

    public double getBroodjesPrijs() {
        return broodjesPrijs;
    }

    public int getBroodjesStock() {
        return broodjesStock;
    }

    public int getAantalBroodjesVerkocht() {
        return aantalBroodjesVerkocht;
    }

    public void aanpassenVoorraad(int aantal){
        setBroodjesStock(this.broodjesStock + aantal);
    }
}
