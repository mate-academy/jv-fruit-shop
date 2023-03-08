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

    public static core.basesyntax.model.TypeOfOperation getByCode(String string) {
        for (core.basesyntax.model.TypeOfOperation type
                : core.basesyntax.model.TypeOfOperation.values()) {
            if (string.equals(type.getCode())) {
                return type;
            }
        }
        throw new RuntimeException("This code not allowed by the type of operation!");
    }
}
