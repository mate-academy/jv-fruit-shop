package operation;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, OperationType> BY_SHORTNAME = new HashMap<>();

    static {
        for (OperationType e: values()) {
            BY_SHORTNAME.put(e.shortName, e);
        }
    }

    private String shortName;

    OperationType(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static OperationType valueOfShortName(String shortName) {
        return BY_SHORTNAME.get(shortName);
    }
}
