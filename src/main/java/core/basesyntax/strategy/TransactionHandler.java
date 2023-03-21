package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitsStorage;

public interface TransactionHandler {
    FruitsStorage currentFruits(FruitsStorage currentFruits, FruitTransaction newTransaction);
}
