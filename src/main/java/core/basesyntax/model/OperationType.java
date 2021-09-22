package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, OperationType> BY_LABEL = new HashMap<>();
    private final String shortOperation;

    OperationType(String shortOperation) {
        this.shortOperation = shortOperation;
    }

    public String getShortOperation() {
        return shortOperation;
    }

    static {
        for (OperationType e : values()) {
            BY_LABEL.put(e.shortOperation, e);
        }
    }

    public static OperationType valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
