package core.basesyntax.service;

import core.basesyntax.fruittransaction.FruitTransaction;
import java.util.List;

public interface TransactionService {
    void handleTransaction(List<FruitTransaction> transactionList);
}
