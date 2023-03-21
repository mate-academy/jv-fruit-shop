package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitsStorage;

public class TransactionSupply implements TransactionHandler {

    @Override
    public FruitsStorage currentFruits(FruitsStorage currentFruits, FruitTransaction newTransaction) {
        return new FruitsStorage(newTransaction.getFruit()
                , currentFruits.getQuantity() + newTransaction.getQuantity());
    }
}
