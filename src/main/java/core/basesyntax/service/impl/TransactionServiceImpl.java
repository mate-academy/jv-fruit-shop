package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.TransactionService;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public TransactionServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void executeTransaction(FruitTransaction fruitTransaction) {
        operationHandlerMap.get(fruitTransaction.getOperation()).execute(fruitTransaction);
    }
}
