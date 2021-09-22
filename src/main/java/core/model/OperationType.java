package core.model;

public enum OperationType {
    PURCHASE("p"),
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r");

    private String shortName;

    OperationType(String shortName) {
        this.shortName = shortName;
    }

    public static OperationType operationTypeOfShortName(String shortName) {
        for (OperationType value : values()) {
            if (value.shortName.equals(shortName)) {
                return value;
            }
        }
        return null;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
