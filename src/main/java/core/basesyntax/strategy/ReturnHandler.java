package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public void calculate(FruitTransaction transaction) {
        Storage.fruitInventory
                .put(transaction.getFruit(), Storage.fruitInventory.get(transaction.getFruit())
                        + transaction.getQuantity());
    }
}
