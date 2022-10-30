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
    public void doOperationService(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .forEach(i -> operationStrategy.get(i.getOperation())
                        .operationWithFruitTransaction(i));
    }
}
