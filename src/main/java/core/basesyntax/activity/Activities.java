package core.basesyntax.activity;

public enum Activities {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String activity;

    Activities(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }
}
