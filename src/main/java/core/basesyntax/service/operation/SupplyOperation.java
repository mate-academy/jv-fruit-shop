package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void processWithTransaction(FruitTransaction transaction) {
        if (Storage.getFruits().containsKey(transaction.getFruit())) {
            int quantity = Storage.getFruits().get(transaction.getFruit());
            Storage.getFruits().put(transaction.getFruit(),transaction.getQuantity() + quantity);
        }
        Storage.getFruits().put(transaction.getFruit(), transaction.getQuantity());
    }
}
