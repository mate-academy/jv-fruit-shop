package core.basesyntax.dao;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Operation getOperation(String abbreviation) {
        for (Operation operation : values()) {
            if (operation.getCode().equals(abbreviation)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("No constant with abbreviation "
                + abbreviation + " found");
    }

    public static boolean validAbbreviation(String abbreviation) {
        for (Operation operation : values()) {
            if (operation.getCode().equals(abbreviation)) {
                return true;
            }
        }
        return false;
    }
}
