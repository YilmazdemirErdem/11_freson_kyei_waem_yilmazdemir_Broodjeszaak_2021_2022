package model.database.loadSaveStrategies;

/**
 * @Author: Mattias Waem, Erdem Yilmazdemir, Yannic Freson, Dazzy Kyei
 */

public enum LoadSaveStrategyEnum {

    TEKST("tekst"), EXCEL("excel");

    private String stringValue;

    private LoadSaveStrategyEnum(String stringValue){
        this.stringValue=stringValue;
    }

    public String getStringValue() {return stringValue;}
}
