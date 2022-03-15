package core.basesyntax.activity;

public enum ActivityTypes {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String activity;

    ActivityTypes(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }
}

