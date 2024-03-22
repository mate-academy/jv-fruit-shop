package core.basesyntax.service.functionalityexpansion;

public enum ActivityType {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private final String code;

    ActivityType(String code) {
        this.code = code;
    }

    public static ActivityType getByCode(String code) {
        for (ActivityType type : ActivityType.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown activity code: " + code);
    }
}
