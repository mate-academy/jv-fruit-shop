package core.basesyntax;

import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.StorageOperation;
import core.basesyntax.operations.SupplyAndReturnOperation;
import java.util.HashMap;
import java.util.Map;

public class OperationProvider {

    private final Map<String, StorageOperation> operationStrategy = new HashMap<>();

    public OperationProvider() {
        operationStrategy.put("b", new PurchaseOperation());
        operationStrategy.put("r", new SupplyAndReturnOperation());
        operationStrategy.put("s", new SupplyAndReturnOperation());
    }

    public StorageOperation getStorageOperation(String type) {
        return operationStrategy.get(type);
    }

}
