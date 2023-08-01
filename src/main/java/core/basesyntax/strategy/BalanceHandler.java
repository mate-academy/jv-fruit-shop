package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void handleOperation(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();

        Storage.fruitStorage.put(fruitName, quantity);
    }
}
