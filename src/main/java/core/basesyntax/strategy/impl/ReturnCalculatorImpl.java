package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TypeCalculatorStrategy;

public class ReturnCalculatorImpl implements TypeCalculatorStrategy {
    @Override
    public void calculate(FruitTransaction transaction) {
        int prevFruitQuantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(),
                transaction.getQuantity() + prevFruitQuantity);
    }

    @Override
    public boolean test(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.RETURN == operation;
    }
}
