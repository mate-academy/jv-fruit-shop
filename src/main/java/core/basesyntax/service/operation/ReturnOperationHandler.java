package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void getTransaction(FruitTransaction fruitTransaction) {
        Integer quantityAfterTransaction
                = Storage.remainsOfFruits.merge(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), Integer::sum);
        Storage.remainsOfFruits.put(fruitTransaction.getFruit(), quantityAfterTransaction);
    }
}
