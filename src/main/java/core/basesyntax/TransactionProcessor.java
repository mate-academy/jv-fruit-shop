package core.basesyntax;

import core.basesyntax.operationstrategy.OperationStrategy;

public class TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessor(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }
}
