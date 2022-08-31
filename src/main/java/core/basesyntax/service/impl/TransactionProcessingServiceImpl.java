package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessingService;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessingServiceImpl implements TransactionProcessingService {
    private final OperationStrategy operationStrategy;

    public TransactionProcessingServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculate(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(f -> operationStrategy.get(f.getOperation()).updateStorage(f));
    }
}
