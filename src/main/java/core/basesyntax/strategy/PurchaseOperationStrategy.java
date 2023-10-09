package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.FruitStorage;

public class PurchaseOperationStrategy implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getAmount() < 0) {
            throw new RuntimeException("The balance is negative");
        }

        FruitStorage.fruitStorage.merge(fruitTransaction.getName(),
                -fruitTransaction.getAmount(), Integer::sum);
    }
}
