package core.basesyntax.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationService;

public class Return implements OperationService {
    private StorageImpl storageImpl;

    public Return(StorageImpl storage) {
        this.storageImpl = storageImpl;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int totalQuantity = Storage.storage.getOrDefault(fruitTransaction.getFruit(), 0);
        Storage.storage.put(fruitTransaction.getFruit(),
                totalQuantity + fruitTransaction.getQuantity());
    }
}
