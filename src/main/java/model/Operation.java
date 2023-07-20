package model;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> CACHED_LABELS = new HashMap<>();
    private final String label;

    static {
        for (Operation o : values()) {
            CACHED_LABELS.put(o.label, o);
        }
    }

    Operation(String label) {
        this.label = label;
    }

    public static Operation getByLabel(String label) {
        return CACHED_LABELS.get(label);
    }
}
