package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentQuantity = FruitStorage.fruitsStorage.get(transaction.getFruit());
        FruitStorage.fruitsStorage.put(transaction.getFruit(), currentQuantity
                + transaction.getQuantity());
    }
}
