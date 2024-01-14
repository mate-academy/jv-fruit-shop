package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionService {
    FruitTransaction createTransaction(String line);
}
