package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionProcessor;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    @Override
    public void transaction(List<FruitTransaction> fruitTransactions,
                            OperationStrategy operationStrategy) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.getStrategy(transaction.getOperation())
                    .calculate(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
