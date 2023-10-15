package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionExecutorImpl implements TransactionExecutor {
    private Map<Operation, OperationHandler> operationHandlers;
    private Storage storage;

    public TransactionExecutorImpl(Storage storage) {
        this.operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE,
                new BalanceOperationHandler(storage));
        operationHandlers.put(Operation.PURCHASE,
                new PurchaseOperationHandler(storage));
        operationHandlers.put(Operation.RETURN,
                new ReturnOperationHandler(storage));
        operationHandlers.put(Operation.SUPPLY,
                new SupplyOperationHandler(storage));
    }

    @Override
    public void executeTransaction(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationHandlers.get(transaction.getOperation()).handleOperation(transaction);
        }
    }
}
