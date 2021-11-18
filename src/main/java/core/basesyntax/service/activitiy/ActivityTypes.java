package core.basesyntax.service.activitiy;

public enum ActivityTypes {
    BALANCE("b"),
    SUPPLY("s"),
    RETURN("r"),
    PURCHASE("p");

    private final String name;

    ActivityTypes(String activityTypeLetter) {
        this.name = activityTypeLetter;
    }

    public String getLetter() {
        return this.name;
    }
}
