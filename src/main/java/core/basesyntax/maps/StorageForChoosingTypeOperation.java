package core.basesyntax.maps;

import core.basesyntax.activities.OperationHandler;
import core.basesyntax.transactions.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class StorageForChoosingTypeOperation {
    private Map<FruitTransaction.Operation, OperationHandler>
            choosingTypeOperations = new HashMap<FruitTransaction.Operation, OperationHandler>();

    public Map<FruitTransaction.Operation, OperationHandler> getChoosingTypeOperations() {
        return choosingTypeOperations;
    }

    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return choosingTypeOperations.get(operation);
    }
}
