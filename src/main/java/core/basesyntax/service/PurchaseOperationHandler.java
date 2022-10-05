package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Integer previousValue = Storage.getStorage().get(transaction.getFruit());

        if (previousValue < transaction.getAmount()) {
            throw new RuntimeException("The amount of fruits less to sell");
        } else {
            Storage.getStorage().put(transaction.getFruit(),
                    (previousValue == null ? 0 : previousValue) - transaction.getAmount());
        }

    }
}
