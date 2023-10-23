package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.IllegalQuantityException;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int balanceQuantity = fruitTransaction.getQuantity();

        if (balanceQuantity < 0) {
            throw new IllegalQuantityException("Transaction \"balance\" can`t be negative value");
        }

        Storage.fruitStorage.put(fruitName, balanceQuantity);
    }
}
