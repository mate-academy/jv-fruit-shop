package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private final Map<Operation, OperationHandler> operationHandlerMap;

    public TransactionServiceImpl(Map<Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void executeTransactions(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            operationHandlerMap.get(transaction.getOperation()).execute(transaction);
        }
    }
}
