package core.basesyntax.model;

public enum FruitOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private String code;

    FruitOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
