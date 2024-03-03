package core.basesyntax.service;

import core.basesyntax.entity.FruitTransaction;

public interface TransactionService {

    void writeTransactionToFile(FruitTransaction fruitTransaction);
}
