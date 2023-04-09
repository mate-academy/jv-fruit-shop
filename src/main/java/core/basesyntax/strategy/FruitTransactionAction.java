package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionAction {
    Integer transactionAction(FruitTransaction fruitTransaction);
}
