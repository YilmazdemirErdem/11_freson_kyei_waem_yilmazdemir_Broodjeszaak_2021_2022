package model;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public class BelegSoort {

    private String belegNaam;
    private double belegPrijs;
    private int belegStock, aantalBelegVerkocht;

    public BelegSoort(String belegNaam, double belegPrijs, int belegStock, int aantalBelegVerkocht) {
        setBelegNaam(belegNaam);
        setBelegPrijs(belegPrijs);
        setBelegStock(belegStock);
        setAantalBelegVerkocht(aantalBelegVerkocht);
    }

    public String getBelegNaam() {
        return belegNaam;
    }

    public void setBelegNaam(String belegNaam) {
        this.belegNaam = belegNaam;
    }

    public double getBelegPrijs() {
        return belegPrijs;
    }

    public void setBelegPrijs(double belegPrijs) {
        this.belegPrijs = belegPrijs;
    }

    public int getBelegStock() {
        return belegStock;
    }

    public void setBelegStock(int belegStock) {
        this.belegStock = belegStock;
    }

    public int getAantalBelegVerkocht() {
        return aantalBelegVerkocht;
    }

    public void setAantalBelegVerkocht(int aantalBelegVerkocht) {
        this.aantalBelegVerkocht = aantalBelegVerkocht;
    }

    public void aanpassenVoorraad(int aantal) {
        setBelegStock(this.belegStock + aantal);
    }
}