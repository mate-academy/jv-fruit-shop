package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void getTransaction(FruitTransaction fruitTransaction) {
        int quantityAfterTransaction = Storage.remainsOfFruits.get(fruitTransaction.getFruit())
                + fruitTransaction.getQuantity();
        Storage.remainsOfFruits.put(fruitTransaction.getFruit(), quantityAfterTransaction);
    }
}
