package core.basesyntax.model;

public enum ActivityType {
    BALANCE('b'),
    PURCHASE('p'),
    RETURN('r'),
    SUPPLY('s');

    private char activityIdentifier;

    ActivityType(char activityIdentifier) {
        this.activityIdentifier = activityIdentifier;
    }

    public char getActivityIdentifier() {
        return activityIdentifier;
    }
}
