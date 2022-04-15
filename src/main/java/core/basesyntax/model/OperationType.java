package core.basesyntax.model;

public enum OperationType {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private final String type;

    OperationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
