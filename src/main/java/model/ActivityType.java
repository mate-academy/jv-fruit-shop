package model;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    ActivityType(String code) {
        this.code = code;
    }

    public static ActivityType fromCode(String code) {
        for (ActivityType type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No ActivityType found with code: " + code);
    }
}
