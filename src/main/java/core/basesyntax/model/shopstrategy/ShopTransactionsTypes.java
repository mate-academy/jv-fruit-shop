package core.basesyntax.model.shopstrategy;

public enum ShopTransactionsTypes {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    
    private String value;
    
    ShopTransactionsTypes(String value) {
        this.value = value;
    }
    
    public static ShopTransactionsTypes getAction(String value) {
        return java.util.Arrays.stream(ShopTransactionsTypes.values())
                .filter(i -> i.value.equalsIgnoreCase(value))
                .findFirst().get();
    }
    
    public String getValue() {
        return value;
    }
}
