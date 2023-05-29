package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransaction(List<FruitTransaction> data) {
        data.forEach(fruitTransaction -> {
            OperationHandler handler = operationStrategy.getOperation(fruitTransaction);
            handler.operationByTransaction(fruitTransaction);
        });
    }
}
