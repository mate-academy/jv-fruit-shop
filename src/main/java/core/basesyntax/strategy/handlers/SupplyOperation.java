package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        int pastValue = Storage.fruits.get(transaction.getFruit());
        Storage.fruits.put(transaction.getFruit(),pastValue + transaction.getQuantity());
    }
}
