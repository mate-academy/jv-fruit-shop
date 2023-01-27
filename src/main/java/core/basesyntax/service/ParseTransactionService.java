package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface ParseTransactionService {
    FruitTransaction parseTransaction(String line);
}
