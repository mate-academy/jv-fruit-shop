package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> OPERATION_MAP = new HashMap<>();
    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    static {
        for (Operation op : Operation.values()) {
            OPERATION_MAP.put(op.getCode(), op);
        }
    }

    public static Operation fromCode(String code) {
        Operation operation = OPERATION_MAP.get(code);
        if (operation == null) {
            throw new RuntimeException("Bad operation type: " + code);
        }
        return operation;
    }
}
