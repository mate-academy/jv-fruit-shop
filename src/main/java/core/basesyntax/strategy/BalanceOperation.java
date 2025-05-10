package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < 0) {
            throw new RuntimeException("We are lacking of fruits...");
        }
        Storage.setFruitQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
