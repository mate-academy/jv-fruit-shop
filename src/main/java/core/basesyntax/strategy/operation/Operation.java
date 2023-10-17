package core.basesyntax.strategy.operation;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> operations = new HashMap<>();
    private final String operationShortcut;

    static {
        for (Operation o: values()) {
            operations.put(o.operationShortcut, o);
        }
    }

    Operation(String operationShortcut) {
        this.operationShortcut = operationShortcut;
    }

    public static Operation get(String operationShortcut) {
        return operations.get(operationShortcut);
    }
}
