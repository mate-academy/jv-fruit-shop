package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandlingService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DataHandlingServiceImpl implements DataHandlingService {
    private final OperationStrategy operationStrategy;

    public DataHandlingServiceImpl(OperationStrategy operationStrategy) {
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
