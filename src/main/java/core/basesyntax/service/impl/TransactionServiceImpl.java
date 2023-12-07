package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public TransactionServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void executeTransactions(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(t -> operationHandlerMap.get(t.getOperation())
                .handleOperation(t));
    }
}
