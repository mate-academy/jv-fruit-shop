package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StorageStrategy;
import java.util.List;

public class StorageStrategyImpl implements StorageStrategy {
    private final int strategyCell = 0;
    private final int fruitCell = 1;
    private final int fruitAmountCell = 2;
    private OperationStrategy operationStrategy;

    public StorageStrategyImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveAll(List<String[]> fruits) {
        for (String[] line: fruits) {
            operationStrategy.getOperationHandler(line[strategyCell])
                    .execute(line[fruitCell], Integer.parseInt(line[fruitAmountCell]));
        }
    }
}
