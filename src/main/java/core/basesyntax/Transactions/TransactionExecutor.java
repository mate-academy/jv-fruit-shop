package core.basesyntax.Transactions;

import core.basesyntax.operations.OperationStrategyImpl;

public class TransactionExecutor {
    OperationStrategyImpl strategy = new OperationStrategyImpl();
    public void transactionExecute(FruitTransaction transaction) {
        strategy.get(transaction);
    }
}
