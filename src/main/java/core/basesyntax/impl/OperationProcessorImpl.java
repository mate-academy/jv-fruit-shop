package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationProcessor;
import core.basesyntax.strategy.OperationHandler;

import java.util.List;
import java.util.Map;

public class OperationProcessorImpl implements OperationProcessor {
    private  Map<FruitTransaction.Operation , OperationHandler> processedOperations;
    public OperationProcessorImpl(Map<FruitTransaction.Operation , OperationHandler> processedOperations){
        this.processedOperations = processedOperations;
    }
    @Override
    public void manageTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            processedOperations.get(transaction.getOperation()).calculateOperation(transaction);
        }
    }
}
