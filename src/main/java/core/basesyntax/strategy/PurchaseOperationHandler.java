package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void perfomOperation(FruitTransaction fruitTransaction) {
        Integer storageQuantity = Storage.fruits.get(fruitTransaction.getFruit());
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (storageQuantity > transactionQuantity) {
            Storage.fruits.put(fruitTransaction.getFruit(), storageQuantity - transactionQuantity);
        } else {
            throw new RuntimeException("Not enough fruits to complete transaction "
                    + fruitTransaction);
        }
    }
}
