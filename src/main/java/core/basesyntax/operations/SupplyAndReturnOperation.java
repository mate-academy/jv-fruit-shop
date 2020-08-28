package core.basesyntax.operations;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.Operation;

public class SupplyAndReturnOperation implements StorageOperation {

    @Override
    public void doStorageOperation(Operation operation) {
        FruitStorage.fruitStorage.merge(operation.getFruit(),
                operation.getQuantity(),
                Integer::sum);
        FruitStorage.expiration.put(operation.getFruit(), operation.getExpDate());
    }
}
