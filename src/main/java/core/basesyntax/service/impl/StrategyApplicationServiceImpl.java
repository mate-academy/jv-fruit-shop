package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.service.StrategyApplicationService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StrategyApplicationServiceImpl implements StrategyApplicationService {
    private static final Integer OPERATION_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private OperationStrategy operationStrategy;

    public StrategyApplicationServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void applyOperationStrategy(List<String[]> data) {
        for (String[] item : data) {
            operationStrategy.get(Operation.getByCode(item[OPERATION_INDEX]))
                    .apply(item[FRUIT_INDEX], Integer.parseInt(item[QUANTITY_INDEX]));
        }
    }
}
