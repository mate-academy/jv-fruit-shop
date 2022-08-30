package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionService {
    FruitTransaction createTransaction(String[] transactionData);
}
