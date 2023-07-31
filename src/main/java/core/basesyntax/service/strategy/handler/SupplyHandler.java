package core.basesyntax.service.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction) {
        Storage.getStorage().replace(transaction.getFruit(),
                Storage.getStorage().get(transaction.getFruit()) + transaction.getQuantity());
    }
}
