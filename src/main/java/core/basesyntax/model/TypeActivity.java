package core.basesyntax.model;

public enum TypeActivity {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    TypeActivity(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
