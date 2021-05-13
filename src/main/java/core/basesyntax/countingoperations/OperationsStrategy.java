package core.basesyntax.countingoperations;

import core.basesyntax.operationswithfile.Transaction;

public interface OperationsStrategy {
    Integer getStrategy(Transaction transaction);
}
