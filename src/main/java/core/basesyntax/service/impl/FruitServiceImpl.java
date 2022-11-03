package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void doOperation(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .forEach(transaction -> operationStrategy.getOperation(transaction.getOperation())
                        .operationWithFruitTransaction(transaction));
    }
}
