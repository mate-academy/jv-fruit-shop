package basesyntax.strategy;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.getFruits()
                .put(transaction.getFruit(), transaction.getQuantity());
    }
}
