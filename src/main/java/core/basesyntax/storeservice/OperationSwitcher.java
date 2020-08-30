package core.basesyntax.storeservice;

import java.util.HashMap;
import java.util.Map;

public class OperationSwitcher {
    private final Map<String, Operation> storageOperations = new HashMap<>();

    public OperationSwitcher() {
        storageOperations.put("s", new Supplier());
        storageOperations.put("b", new Buyer());
        storageOperations.put("r", new Supplier());
    }

    public Operation getOperation(String type) {
        return storageOperations.get(type);
    }
}
