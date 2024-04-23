package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        int quantity = FruitStorageImpl.fruitStorage.get(transaction.getFruit());
        if (quantity <= 0) {
            throw new RuntimeException("The product is not available");
        }
        FruitStorageImpl.fruitStorage.put(transaction.getFruit(),
                FruitStorageImpl.fruitStorage.get(transaction.getFruit()) - transaction.getQuantity());
    }
}
