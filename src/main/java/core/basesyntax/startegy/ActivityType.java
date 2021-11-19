package core.basesyntax.startegy;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String abbreviationActivityType;

    ActivityType(String abbreviationActivityType) {
        this.abbreviationActivityType = abbreviationActivityType;
    }

    public String getAbbreviationActivityType() {
        return abbreviationActivityType;
    }

    public static ActivityType getActivityType(String abbreviationActivityType) {
        for (ActivityType typeActivity: ActivityType.values()) {
            if (typeActivity.getAbbreviationActivityType().equals(abbreviationActivityType)) {
                return typeActivity;
            }
        }
        return null;
    }
}
