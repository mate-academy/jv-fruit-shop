package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceCalculator implements TypeCalculatorStrategy {
    @Override
    public void calculate(FruitTransaction transaction) {
        Storage.STORAGE.put(transaction.getFruit(),
                transaction.getQuantity());
    }

    @Override
    public boolean test(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.BALANCE == operation;
    }
}
