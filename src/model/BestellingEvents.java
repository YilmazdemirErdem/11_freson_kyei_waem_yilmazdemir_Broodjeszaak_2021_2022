package model;

public enum BestellingEvents {

    TOEVOEGEN_BROODJE("toevoegen_broodje"), NIEUWE_BESTELLING("nieuwe_bestelling");

    private String stringValue;

    private BestellingEvents(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}
}