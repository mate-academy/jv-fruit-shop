package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StorageStrategy;
import java.util.List;

public class StorageStrategyImpl implements StorageStrategy {
    private OperationStrategy operationStrategy;

    public StorageStrategyImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveAll(List<String[]> fruits) {
        for (String[] line: fruits) {
            operationStrategy.getOperationHandler(line[0])
                    .execute(line[1], Integer.parseInt(line[2]));
        }
    }
}
