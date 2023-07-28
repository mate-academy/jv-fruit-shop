package core.basesyntax.service.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Storage.storage.replace(transaction.getFruit(),
                Storage.storage.get(transaction.getFruit()) + transaction.getQuantity());
    }
}
