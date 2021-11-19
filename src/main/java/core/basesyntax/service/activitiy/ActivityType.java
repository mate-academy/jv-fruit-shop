package core.basesyntax.service.activitiy;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String name;

    ActivityType(String activityType) {
        this.name = activityType;
    }

    public String getLetter() {
        return this.name;
    }
}
