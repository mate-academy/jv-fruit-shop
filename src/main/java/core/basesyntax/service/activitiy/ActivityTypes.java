package core.basesyntax.service.activitiy;

public enum ActivityTypes {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String name;

    ActivityTypes(String activityTypeLetter) {
        name = activityTypeLetter;
    }

    public String toString() {
        return this.name;
    }
}
