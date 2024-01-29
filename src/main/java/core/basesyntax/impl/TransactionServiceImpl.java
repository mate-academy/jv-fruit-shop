package core.basesyntax.impl;

import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.operations.Operation;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private Map<Operation, OperationHandler> operationOperationHandlerMap;

    public TransactionServiceImpl(Map<Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public void handleTransaction(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction: transactionList) {
            operationOperationHandlerMap.get(transaction.getOperation())
                    .handle(transaction);
        }
    }
}
