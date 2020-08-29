package core.basesyntax.operations;

import core.basesyntax.customexceptions.NoSuchOperation;
import java.util.HashMap;
import java.util.Map;

public class StrategyPerformer {
    private Map<String, Operable> operableMap = new HashMap<>();

    public StrategyPerformer() {
        operableMap.put("b", new Buying());
        operableMap.put("s", new Supplying());
        operableMap.put("r", new Returning());
    }

    public boolean addStrategy(String name, Operable operation) {
        operableMap.put(name, operation);
        return true;
    }

    public Operable getStrategy(String operationType) {
        if (operableMap.containsKey(operationType)) {
            return operableMap.get(operationType);
        } else {
            throw new NoSuchOperation("Wrong operation type!");
        }
    }
}
