package core.basesyntax.services;

import core.basesyntax.transactions.FruitsTransaction;
import java.util.List;

public interface TransactionService {
    void processTransactions(List<FruitsTransaction> transactions);
}
