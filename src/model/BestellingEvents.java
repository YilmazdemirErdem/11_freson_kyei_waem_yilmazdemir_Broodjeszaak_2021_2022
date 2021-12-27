package model;

public enum BestellingEvents {

    IN_WACHT("in_wacht"), IN_BESTELLING("in_bestelling"), TOEVOEGEN_BROODJE("toevoegen_broodje");

    private String stringValue;

    private BestellingEvents(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}
}