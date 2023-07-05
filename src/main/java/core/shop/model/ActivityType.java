package core.shop.model;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private String code;

    ActivityType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static ActivityType fromValue(String value) {
        for (ActivityType activityType : ActivityType.values()) {
            if (activityType.code.equals(value)) {
                return activityType;
            }
        }
        throw new IllegalArgumentException("Invalid activity type value: " + value);
    }
}
