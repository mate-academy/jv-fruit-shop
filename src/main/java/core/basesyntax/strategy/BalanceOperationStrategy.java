package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationStrategy implements OperationStrategy {
    @Override
    public void applyStrategy(FruitTransaction transaction) {
        String fruitName = transaction.getFruit();
        int quantity = transaction.getQuantity();
        Storage storage = Storage.getInstance();
        storage.updateFruitQuantity(FruitTransaction.Operation.BALANCE, fruitName, quantity);
    }
}
