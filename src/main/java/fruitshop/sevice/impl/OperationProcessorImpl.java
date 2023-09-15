package fruitshop.sevice.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.sevice.OperationProcessor;
import fruitshop.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {
    private Map<FruitTransaction.Operation, OperationHandler> processedOperations;

    public OperationProcessorImpl(
            Map<FruitTransaction.Operation, OperationHandler> processedOperations) {
        this.processedOperations = processedOperations;
    }

    @Override
    public void manageTransaction(List<FruitTransaction> transactions) {
        transactions.forEach(t -> processedOperations.get(t.getOperation()).calculateOperation(t));
    }
}
