package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionService {
    void handle(FruitTransaction transaction);
}
