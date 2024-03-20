package core.basesyntax.service;

import core.basesyntax.model.FruitsTransaction;
import java.util.List;

public interface TransactionProcessor {
    void executeTransactions(List<FruitsTransaction> transactions);
}
