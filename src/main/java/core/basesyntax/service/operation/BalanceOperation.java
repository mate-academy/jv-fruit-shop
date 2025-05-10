package core.basesyntax.service.operation;

import core.basesyntax.db.Storage;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(String fruitName, int amount) {
        if (amount <= 0) {
            throw new RuntimeException("Balance amount can't be less than 0");
        }
        int currentAmount = Storage.get(fruitName);
        int newAmount = currentAmount + amount;
        Storage.save(fruitName, newAmount);
    }
}
