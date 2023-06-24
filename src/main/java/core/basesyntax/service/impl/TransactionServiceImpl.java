package core.basesyntax.service.impl;

import core.basesyntax.fruit.Operation;
import core.basesyntax.fruit.Transaction;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public TransactionServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void excuteTransactions(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            operationHandlerMap.get(transaction.getOperation()).execute(transaction);
        }

    }
}
