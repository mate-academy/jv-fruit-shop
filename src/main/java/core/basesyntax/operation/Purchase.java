package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class Purchase implements OperationService {
    private StorageImpl storageImpl;

    public Purchase(StorageImpl storage) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int totalQuantity = Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
        if (totalQuantity > fruitTransaction.getQuantity()) {
            Storage.storage.put(fruitTransaction.getFruit(),
                    totalQuantity - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Total amount of fruit less than bought");
        }
    }
}
