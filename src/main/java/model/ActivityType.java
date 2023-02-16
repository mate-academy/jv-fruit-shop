package model;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String activity;

    ActivityType(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }
}
