package core.basesyntax.service.operationhandler;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private static final Map<String, Operation> operationTypes = new HashMap<>();

    private final String letter;

    Operation(String letter) {
        this.letter = letter;
    }

    public String getType() {
        return letter;
    }

    static {
        for (Operation operation : values()) {
            operationTypes.put(operation.getType(), operation);
        }
    }

    public static Operation get(String letter) {
        return operationTypes.get(letter);
    }
}
