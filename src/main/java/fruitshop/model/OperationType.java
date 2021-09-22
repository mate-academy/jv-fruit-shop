package fruitshop.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String shortName;
    OperationType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static OperationType valueOfLabel(String shortName) {
        OperationType operation = null;
        for (OperationType o: values()) {
            if (o.shortName.equals(shortName)) {
                operation = o;
                break;
            }
        }
        return operation;
    }
}
