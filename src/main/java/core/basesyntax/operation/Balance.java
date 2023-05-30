package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class Balance implements OperationService {
    private StorageImpl storageImpl;

    public Balance(StorageImpl storage) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("The balance should be greater than zero");
        }
        Storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
