package shop.model;

public enum ActionType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String type;

    ActionType(String type) {
        this.type = type;
    }

    public String getAlias() {
        return type;
    }
}
