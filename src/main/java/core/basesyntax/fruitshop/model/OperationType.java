package core.basesyntax.fruitshop.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private final String value;

    OperationType(String value) {
        this.value = value;
    }

    public static OperationType valueOfLabel(String value) {
        for (OperationType o : values()) {
            if (o.value.equals(value)) {
                return o;
            }
        }
        return null;
    }
}
