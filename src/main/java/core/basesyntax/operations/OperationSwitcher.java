package core.basesyntax.operations;

import java.util.HashMap;
import java.util.Map;

public class OperationSwitcher {
    private final Map<String, Operation> storageOperations = new HashMap<>();

    public OperationSwitcher() {
        storageOperations.put("s", new Supply());
        storageOperations.put("b", new Buy());
        storageOperations.put("r", new Supply());
    }

    public Operation getOperation(String type) {
        return storageOperations.get(type);
    }
}
