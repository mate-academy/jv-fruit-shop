package core.basesyntax.strategy.handler;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> BY_CODE = new HashMap<>();

    static {
        for (Operation op : values()) {
            BY_CODE.put(op.code, op);
        }
    }

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation fromCode(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("Operation code is empty");
        }
        Operation op = BY_CODE.get(code.trim().toLowerCase());
        if (op == null) {
            throw new IllegalArgumentException("Unknown operation code: " + code);
        }
        return op;
    }

    public String getCode() {
        return code;
    }
}
