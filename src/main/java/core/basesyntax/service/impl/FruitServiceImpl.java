package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.forEach(fruitTransaction -> operationStrategy
                .get(fruitTransaction.getOperation())
                .applyChanges(fruitTransaction));
    }
}
