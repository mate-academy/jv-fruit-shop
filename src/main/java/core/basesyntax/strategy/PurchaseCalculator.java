package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseCalculator implements TypeCalculatorStrategy {
    @Override
    public void calculate(FruitTransaction transaction) {
        int prevFruitQuantity = Storage.storage.get(transaction.getFruit());
        Storage.storage.put(transaction.getFruit(),
                prevFruitQuantity - transaction.getQuantity());
    }

    @Override
    public boolean test(FruitTransaction.Operation operation) {
        return FruitTransaction.Operation.PURCHASE == operation;
    }
}
