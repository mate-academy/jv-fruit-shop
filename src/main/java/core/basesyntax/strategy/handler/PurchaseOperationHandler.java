package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int fruitsBefore = FruitStorage.getStorage().get(transaction.getFruit());
        int fruitsToRemove = transaction.getQuantity();
        if (fruitsBefore < fruitsToRemove) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        FruitStorage.getStorage().put(transaction.getFruit(), fruitsBefore - fruitsToRemove);
    }
}
