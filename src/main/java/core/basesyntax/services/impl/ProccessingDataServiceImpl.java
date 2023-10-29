package core.basesyntax.services.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.services.ProccessingDataService;
import core.basesyntax.strategy.operations.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProccessingDataServiceImpl implements ProccessingDataService {
    private final Map<Transaction.Operation, OperationHandler> operation;

    public ProccessingDataServiceImpl(Map<Transaction.Operation, OperationHandler> operation) {
        this.operation = operation;
    }

    @Override
    public void process(List<Transaction> data) {
        for (Transaction transaction : data) {
            OperationHandler operationHandler = operation.get(transaction.getOperation());
            operationHandler.proccessOperation(transaction);
        }
    }
}
