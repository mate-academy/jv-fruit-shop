package core.basesyntax.operation;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        FruitStorage.getFruits().put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
