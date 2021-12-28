package model.state.kortingStrategies;

public enum KortingStrategyEnum {
    TIEN_PROCENT_OP_GANSE_BESTELLING("10% korting op ganse bestelling"),
    GOEDKOOPSTE_BROODJE_MET_BELEG_GRATIS("Goedkoopste broodje met beleg gratis");

    private String stringValue;

    private KortingStrategyEnum(String stringValue){
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
