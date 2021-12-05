package model;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    PURCHASE("p"),
    RETURN("r"),
    SUPPLY("s");

    private static final Map<String, Operation> operationMap = new HashMap<>();

    static {
        for (Operation operation : Operation.values()) {
            operationMap.put(operation.getType(), operation);
        }
    }

    private String type;

    Operation(String type) {
        this.type = type;
    }

    public static Operation get(String type) {
        return operationMap.get(type);
    }

    public String getType() {
        return type;
    }
}
