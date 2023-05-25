package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addOperationToStorage(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .forEach(i -> operationStrategy.get(i.getOperation())
                        .handle(i));
    }
}
