package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void proceedTransaction(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.proceedOperation(fruitTransaction);
        }
    }
}
