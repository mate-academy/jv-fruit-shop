package core.basesyntax.service.functionalityexpansion;

public enum ActivityTypeEnum {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private final String code;

    ActivityTypeEnum(String code) {
        this.code = code;
    }

    public static ActivityTypeEnum getByCode(String code) {
        for (ActivityTypeEnum type : ActivityTypeEnum.values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown activity code: " + code);
    }
}
