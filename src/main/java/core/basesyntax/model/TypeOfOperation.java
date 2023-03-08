package core.basesyntax.model;

public enum TypeOfOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    TypeOfOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static TypeOfOperation getByCode(String string) {
        for (TypeOfOperation type
                : TypeOfOperation.values()) {
            if (string.equals(type.getCode())) {
                return type;
            }
        }
        throw new RuntimeException("This code not allowed by the type of operation!");
    }
}
