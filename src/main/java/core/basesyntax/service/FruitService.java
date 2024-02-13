package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;

public interface FruitService {
    void calculate(TransactionService transactionStrategy,
                   FruitTransaction fruitTransaction,
                   FruitStorage fruitStorage);
}
