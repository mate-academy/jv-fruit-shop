package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction) {
        Storage.fruits.put(
                transaction.getFruit(),
                Storage.fruits.getOrDefault(
                        transaction.getFruit(), 0)
                        + transaction.getQuantity()
        );
    }
}
