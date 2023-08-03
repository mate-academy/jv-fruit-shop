package core.basesyntax.service;

import core.basesyntax.interfaces.TransactionExecutor;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.model.FruitTransaction;

import java.util.Map;

public class TransactionExecutorImpl implements TransactionExecutor {
    private final OperationStrategy strategy;

    public TransactionExecutorImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap) {
        this.strategy = new OperationStrategyImpl(operationHandlerMap);
    }


    public void transactionExecute(FruitTransaction transaction) {
        strategy.get(transaction);
    }
}
