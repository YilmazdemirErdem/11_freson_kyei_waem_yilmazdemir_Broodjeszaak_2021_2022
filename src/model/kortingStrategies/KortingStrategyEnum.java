package model.kortingStrategies;

public enum KortingStrategyEnum {
    TIEN_PROCENT_OP_GANSE_BESTELLING("tien_procent_op_ganse_bestelling"),
    GOEDKOOPSTE_BROODJE_MET_BELEG_GRATIS("goedkoopste_broodje_met_beleg_gratis");

    private String stringValue;

    private KortingStrategyEnum(String stringValue){
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
