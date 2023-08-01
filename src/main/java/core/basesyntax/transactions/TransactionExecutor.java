package core.basesyntax.transactions;

import core.basesyntax.operations.OperationStrategyImpl;

public class TransactionExecutor {
    private final OperationStrategyImpl strategy = new OperationStrategyImpl();

    public void transactionExecute(FruitTransaction transaction) {
        strategy.get(transaction);
    }
}
