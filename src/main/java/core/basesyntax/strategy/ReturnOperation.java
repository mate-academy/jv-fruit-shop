package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void process(FruitTransaction fruitTransaction) {
        validateTransaction(fruitTransaction);
        int quantity = Storage.getAll().getOrDefault(fruitTransaction.getFruit(), 0);
        int updatedQuantity = quantity + fruitTransaction.getQuantity();
        Storage.put(fruitTransaction.getFruit(), updatedQuantity);
    }
}
