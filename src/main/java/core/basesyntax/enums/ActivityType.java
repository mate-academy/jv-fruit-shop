package core.basesyntax.enums;

import java.util.HashMap;
import java.util.Map;

public enum ActivityType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, ActivityType> map;
    private final String code;

    static {
        map = new HashMap<>();
        for (ActivityType v : ActivityType.values()) {
            map.put(v.code, v);
        }
    }

    ActivityType(String code) {
        this.code = code;
    }

    public static ActivityType findByCode(String code) {
        return map.get(code);
    }

    public String getCode() {
        return code;
    }
}
