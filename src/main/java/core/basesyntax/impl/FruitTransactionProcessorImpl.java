package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.TransactionProcessor;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.OperationHandlerStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitTransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void transactionProcessor(List<FruitTransaction> fruitTransactionsList,
                                     Map<FruitTransaction.Operation, OperationHandler> strategy) {

        OperationHandlerStrategy operationHandlerStrategy =
                new OperationHandlerStrategyImpl(strategy);

        for (FruitTransaction transaction : fruitTransactionsList) {
            OperationHandler operation = operationHandlerStrategy
                    .getOperationFromFruitTransaction(transaction.getOperation());
            operation.fruitTransactionHandler(transaction);
        }
    }
}
