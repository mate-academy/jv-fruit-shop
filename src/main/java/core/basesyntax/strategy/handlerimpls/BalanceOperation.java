package core.basesyntax.strategy.handlerimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public int apply(Transaction transaction) {
        int currentQuantity = transaction.getQuantity();
        Storage.storage.put(new Fruit(transaction.getName()), currentQuantity);
        return currentQuantity;
    }
}
