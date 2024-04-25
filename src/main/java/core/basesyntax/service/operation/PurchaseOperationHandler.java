package core.basesyntax.service.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.FruitStorageImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitStorage storage = new FruitStorageImpl();

    @Override
    public void process(FruitTransaction transaction) {
        int quantity = storage.getQuantity(transaction.getFruit());
        if (quantity <= 0) {
            throw new RuntimeException("The product is not available");
        }
        storage.add(transaction.getFruit(),
                storage.getQuantity(transaction.getFruit()) - transaction.getQuantity());
    }
}
