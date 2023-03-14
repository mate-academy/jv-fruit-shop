package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionService {
    FruitTransaction createFruitTransaction(String inputLine);
}
