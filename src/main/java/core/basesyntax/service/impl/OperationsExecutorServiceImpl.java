package core.basesyntax.service.impl;

import core.basesyntax.operations.Operational;
import core.basesyntax.service.OperationsExecutorService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationsExecutorServiceImpl implements OperationsExecutorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    private final OperationStrategy fruitOperationStrategy;

    public OperationsExecutorServiceImpl(OperationStrategy fruitOperationStrategy) {
        this.fruitOperationStrategy = fruitOperationStrategy;
    }

    @Override
    public void executeOperations(List<String[]> operationList) {
        for (String[] operationInfo : operationList) {
            Operational operation = fruitOperationStrategy.get(operationInfo[OPERATION_INDEX]);
            operation.action(operationInfo[FRUIT_INDEX],
                    Integer.parseInt(operationInfo[AMOUNT_INDEX]));
        }
    }
}
