package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitsStorage;

public class ActivityPurchase implements TransactionHandler {
    @Override
    public FruitsStorage currentFruits(FruitsStorage currentFruits, FruitTransaction newTransaction) {
        return new FruitsStorage(currentFruits.getName()
                , currentFruits.getQuantity() - newTransaction.getQuantity());
    }
}
