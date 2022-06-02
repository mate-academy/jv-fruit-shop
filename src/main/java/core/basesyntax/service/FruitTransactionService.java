package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionService {
    void getFruitTransactionFromString(String[] dataFromFile);

    void setOperationHandler(FruitTransaction transaction);

    void addToStorage(FruitTransaction transaction);
}
