package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationProcessor;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {
    private final Map<FruitTransaction.Operation, OperationHandler> processedOperations;

    public OperationProcessorImpl(
            Map<FruitTransaction.Operation, OperationHandler> processedOperations) {
        this.processedOperations = processedOperations;
    }

    @Override
    public void manageTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(t -> processedOperations.get(t.getOperation()).calculateOperation(t));
    }
}
