package core.basesyntax.service;

import core.basesyntax.model.Operation;

public interface FruitTransactionService {
    void createTransaction(Operation operation, String fruit, int quantity);
}
