package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface TransactionService {

    FruitTransaction createNewTransaction(FruitTransaction transaction);

    FruitTransaction createInstance(String dataFromReport);

    void updateTransaction(FruitTransaction transaction);

    FruitTransaction findTransactionByOperationAndFruit(FruitTransaction transaction);

}
