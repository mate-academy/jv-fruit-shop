package core.basesyntax.service.activity;

public enum TypeActivity {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String name;

    TypeActivity(String activityTypeLetter) {
        this.name = activityTypeLetter;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
