package core.basesyntax.operations;

import core.basesyntax.customexceptions.NoSuchOperation;
import java.util.HashMap;
import java.util.Map;

public class PerformStrategy {
    public static Map<String, Operable> operableMap = new HashMap<>();

    static {
        operableMap.put("b", new Buying());
        operableMap.put("s", new Supplying());
        operableMap.put("r", new Returning());
    }

    public static Operable getStrategy(String operationType) {
        if (operableMap.containsKey(operationType)) {
            return operableMap.get(operationType);
        } else {
            throw new NoSuchOperation("Wrong operation type!");
        }
    }
}
