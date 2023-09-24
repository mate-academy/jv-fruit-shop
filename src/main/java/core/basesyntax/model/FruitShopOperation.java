package core.basesyntax.model;

public enum FruitShopOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    FruitShopOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static FruitShopOperation fromCode(String code) {
        for (FruitShopOperation fruitShopOperation : FruitShopOperation.values()) {
            if (fruitShopOperation.code.equalsIgnoreCase(code)) {
                return fruitShopOperation;
            }
        }
        throw new IllegalArgumentException("Invalid operation code: " + code);
    }
}
