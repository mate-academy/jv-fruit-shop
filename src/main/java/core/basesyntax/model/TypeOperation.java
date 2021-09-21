package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public enum TypeOperation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, TypeOperation> BY_LABEL = new HashMap<>();
    private final String shortOperation;

    TypeOperation(String shortOperation) {
        this.shortOperation = shortOperation;
    }

    public String getShortOperation() {
        return shortOperation;
    }

    static {
        for (TypeOperation e : values()) {
            BY_LABEL.put(e.shortOperation, e);
        }
    }

    public static TypeOperation valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }
}
