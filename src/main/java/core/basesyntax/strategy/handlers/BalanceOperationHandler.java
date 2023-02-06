package core.basesyntax.strategy.handlers;

import core.basesyntax.database.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.fruitsQuantity.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
