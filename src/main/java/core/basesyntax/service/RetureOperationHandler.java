package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class RetureOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Integer previousValue = Storage.getStorage().get(transaction.getFruit());

        Storage.getStorage().put(transaction.getFruit(),
                (previousValue == null ? 0 : previousValue) + transaction.getAmount());
    }
}
