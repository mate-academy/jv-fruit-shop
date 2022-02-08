package core.basesyntax.service.activitiy;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String name;

    ActivityType(String name) {
        this.name = name;
    }

    public String getLetter() {
        return this.name;
    }
}
