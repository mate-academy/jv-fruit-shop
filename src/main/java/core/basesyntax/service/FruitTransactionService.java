package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionService {
    FruitTransaction createTransaction(String operationCode, String fruit, int quantity);
}
