package core.basesyntax.model;

public enum TypeActivity {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String type;

    TypeActivity(String type) {
        this.type = type;
    }

    public static TypeActivity typeGiven(String type) {
        for (TypeActivity activity : values()) {
            if (activity.type.equals(type)) {
                return activity;
            }
        }
        throw new RuntimeException("Given type is not provided in the file" + type);
    }
}


