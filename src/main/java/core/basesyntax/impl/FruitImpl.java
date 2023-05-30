package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Fruit;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitImpl implements Fruit {
    private final OperationStrategy operationStrategy;

    public FruitImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> data) {
        data.stream()
                .forEach(curTransaction -> {
                    OperationService service =
                            operationStrategy.getOperation(curTransaction);
                    service.calculate(curTransaction);
                });
    }
}
