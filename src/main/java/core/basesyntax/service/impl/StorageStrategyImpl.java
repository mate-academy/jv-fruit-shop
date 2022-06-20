package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.StorageStrategy;
import java.util.List;

public class StorageStrategyImpl implements StorageStrategy {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private OperationStrategy operationStrategy;

    public StorageStrategyImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void saveAll(List<String[]> fruits) {
        for (String[] line: fruits) {
            operationStrategy.getOperationHandler(line[OPERATION_INDEX])
                    .execute(line[FRUIT_INDEX], Integer.parseInt(line[AMOUNT_INDEX]));
        }
    }
}
