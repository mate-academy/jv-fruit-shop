package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public enum Operation {

    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static Map<String, Operation> OPERATION_MAP = new HashMap<>();

    private final String operation;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public static Operation getOperation(String operation) {
        return OPERATION_MAP.get(operation);
    }

    static {
        for (Operation o : Operation.values()) {
            OPERATION_MAP.put(o.operation, o);
        }
    }
}
