package shop;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    SUPPLY("s"),
    RETURN("r");

    private final String type;

    Operation(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
