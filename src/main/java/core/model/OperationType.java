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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
