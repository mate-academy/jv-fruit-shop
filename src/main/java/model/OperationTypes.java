package model;

public enum OperationTypes {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String shortName;

    OperationTypes(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static OperationTypes valueOfShortName(String shortName) {
        for (OperationTypes value : values()) {
            if (value.shortName.equals(shortName)) {
                return value;
            }
        }
        return null;
    }
}
