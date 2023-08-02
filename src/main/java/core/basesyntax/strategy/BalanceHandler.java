package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction can`t be null");
        }

        String fruitName = fruitTransaction.getFruit();
        int balanceQuantity = fruitTransaction.getQuantity();

        if (balanceQuantity < 0) {
            throw new RuntimeException("Transaction \"balance\" can`t be negative value");
        }

        Storage.fruitStorage.put(fruitName, balanceQuantity);
    }
}
