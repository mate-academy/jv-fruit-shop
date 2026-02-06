package basesyntax.strategy;

import basesyntax.db.Storage;
import basesyntax.model.FruitTransaction;
import basesyntax.service.OperationHandler;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        int current = Storage.getFruits()
                .getOrDefault(transaction.getFruit(), 0);
        int result = current - transaction.getQuantity();

        if (result < 0) {
            throw new IllegalStateException(
                    "Not enough fruits: " + transaction.getFruit());
        }
        Storage.getFruits().put(transaction.getFruit(), result);
    }
}
