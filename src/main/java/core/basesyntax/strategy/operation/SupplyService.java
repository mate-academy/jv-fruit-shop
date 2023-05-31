package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class SupplyService implements OperationService {
    private StorageImpl storageImpl;

    public SupplyService(StorageImpl storage) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
        Storage.storage.put(fruitTransaction.getFruit(),
                oldQuantity + fruitTransaction.getQuantity());
    }
}
