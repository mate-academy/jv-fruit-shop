package core.basesyntax.model;

public enum Activities {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r"),
    NOT_FOUND("n");

    private final String code;

    Activities(String code) {
        this.code = code;
    }

    public static Activities fromValue(String value) {
        for (final Activities activities : values()) {
            if (activities.code.equalsIgnoreCase(value)) {
                return activities;
            }
        }
        return NOT_FOUND;
    }
}

