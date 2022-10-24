package core.basesyntax.service;

import java.util.List;

public interface TransactionProcessor {
    void processTransactions(List<String> actions);
}
