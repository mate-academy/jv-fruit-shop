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
    
    public static ShopActions getAction(String value) {
        return java.util.Arrays.stream(ShopActions.values())
                .filter(i -> i.value.equalsIgnoreCase(value))
                .findFirst().get();
    }
    
    public String getValue() {
        return value;
    }
}
