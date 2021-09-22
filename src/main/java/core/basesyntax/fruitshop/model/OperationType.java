package core.basesyntax.fruitshop.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private final String label;

    OperationType(String value) {
        this.label = value;
    }

    public static OperationType valueOfLabel(String value) {
        for (OperationType type : values()) {
            if (type.label.equals(value)) {
                return type;
            }
        }
        throw new RuntimeException("This operation doesn't exist" + value);
    }
}
