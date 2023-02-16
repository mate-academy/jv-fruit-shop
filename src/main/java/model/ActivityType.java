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

    public static ActivityType getByCode(String activity) {
        for (ActivityType activityType : values()) {
            if (activityType.getActivity().equals(activity)) {
                return activityType;
            }
        }
        throw new RuntimeException("There is no such activity" + activity);
    }
}
