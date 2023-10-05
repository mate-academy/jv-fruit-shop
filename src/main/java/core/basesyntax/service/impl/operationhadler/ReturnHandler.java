package core.basesyntax.service.impl.operationhadler;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler {
    @Override
    public void handleTransaction(FruitTransaction transaction) {
        int currentValue = FruitStorage.fruitsStorage.get(transaction.getFruit());
        FruitStorage.fruitsStorage.put(transaction.getFruit(), currentValue
                + transaction.getQuantity());
    }
}
