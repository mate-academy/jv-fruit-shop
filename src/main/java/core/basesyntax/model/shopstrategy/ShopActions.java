package core.basesyntax.model.shopstrategy;

public enum ShopActions {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    
    private String value;
    
    ShopActions(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}
