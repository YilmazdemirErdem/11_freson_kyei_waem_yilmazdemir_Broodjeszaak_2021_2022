package model;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public enum BestellingEvents {

    NIEUWE_BESTELLING("nieuwe_bestelling"), VERWIJDER_BROODJE("verwijder_broodje"), TOEVOEGEN_IDENTIEK_BROODJE("toevoegen_identiek_broodje"), TOEVOEGEN_BELEG("toevoegen_beleg"), AFSLUITEN("afsluiten"), TOEVOEGEN_BROODJE("toevoegen_broodje"), ANNULEREN("annuleren"), BETALEN("betalen"), NAAR_KEUKEN("naar_keuken"), START_BEREIDING("start_bereiding"), AFGEWERKT("afgewerkt");

    private String stringValue;

    private BestellingEvents(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}
}