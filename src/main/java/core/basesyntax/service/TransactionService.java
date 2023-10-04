package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionService {
    void makeTransactions(List<FruitTransaction> transactions);
}
