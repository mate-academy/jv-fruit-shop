package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void perfomOperation(FruitTransaction fruitTransaction) {
        Integer storageQuantity = Storage.fruits.get(fruitTransaction.getFruit());
        Integer transactionQuantity = fruitTransaction.getQuantity();
        Storage.fruits.put(fruitTransaction.getFruit(), storageQuantity + transactionQuantity);
    }
}
