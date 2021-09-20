package core.basesyntax.lib;

public enum ActivitiesEnum {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String activity;

    ActivitiesEnum(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }
}
