package core.basesyntax.maps;

import core.basesyntax.activities.OperationHandler;
import core.basesyntax.transactions.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class StorageForChoosingTypeOperation {
    private final Map<FruitTransaction.Operation, OperationHandler>
            choosingTypeOperations = new HashMap<FruitTransaction.Operation, OperationHandler>();

    public void addHandler(FruitTransaction.Operation operation,
                           OperationHandler handler) {
        choosingTypeOperations.put(operation, handler);
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return choosingTypeOperations.get(operation);
    }
}
