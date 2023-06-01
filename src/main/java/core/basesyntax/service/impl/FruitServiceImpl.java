package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategyImpl operationStrategy;

    public FruitServiceImpl(OperationStrategyImpl operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        for (FruitTransaction fruitTransaction : data) {
            operationStrategy.get(fruitTransaction.getOperation())
                    .handle(fruitTransaction);
        }
    }
}
