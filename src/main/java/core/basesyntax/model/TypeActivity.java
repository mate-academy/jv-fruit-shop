package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public enum TypeActivity {
    BALANCE("b"), SUPPLY("s"), PURCHASE("p"), RETURN("r");

    private static final Map<String, TypeActivity> BY_LABEL = new HashMap<>();

    static {
        for (TypeActivity type: values()) {
            BY_LABEL.put(type.label, type);
        }
    }

    private final String label;

    TypeActivity(String label) {
        this.label = label;
    }

    public static TypeActivity getByLabel(String label) {
        return BY_LABEL.get(label);
    }

    public int getSign() {
        return this == PURCHASE ? -1 : 1;
    }
}
