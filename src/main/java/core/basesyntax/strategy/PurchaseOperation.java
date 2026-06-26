package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction) {
        int current = Storage.getFruitQuantity(transaction.getFruit());

        if (current - transaction.getQuantity() < 0) {
            throw new RuntimeException(
                    "Not enough " + transaction.getFruit() + " in storage");
        }

        Storage.putFruit(
                transaction.getFruit(),
                current - transaction.getQuantity()
        );
    }
}
