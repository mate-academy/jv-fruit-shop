package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    FruitTransaction createTransaction(String s);

    List<FruitTransaction> getListOfTransactionsFromString(String transactions);

    void processAllTransactions(List<FruitTransaction> transactions);
}
