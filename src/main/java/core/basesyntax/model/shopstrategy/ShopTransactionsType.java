package core.basesyntax.model.shopstrategy;

import java.util.Arrays;

public enum ShopTransactionsType {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    
    private String value;
    
    ShopTransactionsType(String value) {
        this.value = value;
    }
    
    public static ShopTransactionsType getAction(String value) {
        return Arrays.stream(ShopTransactionsType.values())
                .filter(i -> i.value.equalsIgnoreCase(value))
                .findFirst().get();
    }
    
    public String getValue() {
        return value;
    }
}
