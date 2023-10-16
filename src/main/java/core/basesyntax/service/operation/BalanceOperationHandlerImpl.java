package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantityFruit = transaction.getQuantity();
        Storage.storage.put(fruitName, quantityFruit);
    }
}
