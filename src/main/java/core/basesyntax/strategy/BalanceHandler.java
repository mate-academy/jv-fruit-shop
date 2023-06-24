package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        Storage.fruits
                .put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
