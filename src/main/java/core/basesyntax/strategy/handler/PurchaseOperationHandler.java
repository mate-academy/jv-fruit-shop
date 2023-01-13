package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int balance = FruitStorage.getStorage().get(transaction.getFruit());
        int fruitsToRemove = transaction.getQuantity();
        if (balance < fruitsToRemove) {
            throw new RuntimeException("Not enough fruits in storage.You have: " + balance);
        }
        FruitStorage.getStorage().put(transaction.getFruit(), balance - fruitsToRemove);
    }
}
