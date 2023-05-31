package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class PurchaseService implements OperationService {
    private StorageImpl storageImpl;

    public PurchaseService(StorageImpl storage) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void process(FruitTransaction fruitTransaction) {
        int oldQuantity = Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
        if (oldQuantity > fruitTransaction.getQuantity()) {
            Storage.storage.put(fruitTransaction.getFruit(),
                    oldQuantity - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Total amount of fruit less than bought");
        }
    }
}
