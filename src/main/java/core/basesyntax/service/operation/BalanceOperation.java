package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void processWithTransaction(FruitTransaction transaction) {
        Storage.getFruits().get(transaction.getFruit());
    }
}
