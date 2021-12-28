package model.state.kortingStrategies;

public enum KortingStrategyEnum {
    TIEN_PROCENT_OP_GANSE_BESTELLING("10%_korting_op_ganse_bestelling"),
    GOEDKOOPSTE_BROODJE_MET_BELEG_GRATIS("Goedkoopste_broodje_met_beleg_gratis");

    private String stringValue;

    private KortingStrategyEnum(String stringValue){
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
