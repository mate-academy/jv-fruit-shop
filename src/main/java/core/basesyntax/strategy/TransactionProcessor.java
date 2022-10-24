package core.basesyntax.strategy;

import java.util.List;

public interface TransactionProcessor {
    void processTransactions(List<String> actions);
}
