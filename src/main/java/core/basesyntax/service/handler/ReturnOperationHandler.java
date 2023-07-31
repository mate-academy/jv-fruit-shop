package core.basesyntax.service.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void processTransaction(FruitTransaction transaction) {
        int quantityFruit = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(), transaction.getQuantity() + quantityFruit);
    }
}
