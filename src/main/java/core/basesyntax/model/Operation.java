package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");
    private String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
