package core.basesyntax.service.activitiy;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String name;

    ActivityType(String activityTypeLetter) {
        this.name = activityTypeLetter;
    }

    public String getLetter() {
        return this.name;
    }
}
