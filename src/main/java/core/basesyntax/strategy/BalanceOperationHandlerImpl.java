package core.basesyntax.strategy;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        FruitStorage.fruitQuantities.put(transaction.getFruit(), transaction.getQuantity());
    }
}

