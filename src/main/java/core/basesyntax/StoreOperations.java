package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class StoreOperations {
    static final Map<String, IntBinaryOperator> AVAILABLE_OPERATIONS = new HashMap<>();

    static {
        AVAILABLE_OPERATIONS.put("s", (x, y) -> x + y);
        AVAILABLE_OPERATIONS.put("b", (x, y) -> x - y);
        AVAILABLE_OPERATIONS.put("r", (x, y) -> x + y);
    }

    static int calculate(int x, int y, String operationSymbol) {
        if (!AVAILABLE_OPERATIONS.containsKey(operationSymbol)) {
            throw new IllegalArgumentException("Provided operation is not supported");
        }
        return AVAILABLE_OPERATIONS.get(operationSymbol).applyAsInt(x, y);
    }
}
