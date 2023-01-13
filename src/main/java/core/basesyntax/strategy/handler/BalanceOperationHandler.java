package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        int balance = transaction.getQuantity();
        if (balance < 0) {
            throw new RuntimeException("Balance must be positive! " + balance);
        } else {
            FruitStorage.getStorage().put(transaction.getFruit(), balance);
        }
    }
}
