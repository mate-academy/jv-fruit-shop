package core.basesyntax.model;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    
    private final String operation;

    private static final Map<String,Operation> ENUM_MAP;

    Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    static {
        Map<String,Operation> map = new HashMap<>();
        for (final Operation instance : Operation.values()) {
            map.put(instance.getOperation(),instance);
        }
        ENUM_MAP = map;
    }

    public static Operation get(String operation){
        Operation o = ENUM_MAP.get(operation);
        if(o == null){
            throw new RuntimeException("Couldn't find enum value for " + operation);
        }
        return o;
    }
}
