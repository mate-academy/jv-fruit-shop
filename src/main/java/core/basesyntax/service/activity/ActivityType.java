package core.basesyntax.service.activity;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String name;

    ActivityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
