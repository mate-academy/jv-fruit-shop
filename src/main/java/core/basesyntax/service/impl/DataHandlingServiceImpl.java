package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandlingService;
import core.basesyntax.strategy.FruitService;
import core.basesyntax.strategy.OperationService;
import java.util.List;

public class DataHandlingServiceImpl implements DataHandlingService {
    private final FruitService operationStrategy;

    public DataHandlingServiceImpl(FruitService operationStrategy) {
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
