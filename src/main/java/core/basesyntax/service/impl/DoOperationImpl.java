package core.basesyntax.service.impl;

import core.basesyntax.operations.Operation;
import core.basesyntax.service.DoOperations;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class DoOperationImpl implements DoOperations {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final OperationStrategy fruitOperationStrategy;

    public DoOperationImpl(OperationStrategy fruitOperationStrategy) {
        this.fruitOperationStrategy = fruitOperationStrategy;
    }

    @Override
    public void closeAllOperations(List<String[]> operationList) {
        for (String[] operationInfo : operationList) {
            Operation operation = fruitOperationStrategy.get(operationInfo[OPERATION_INDEX]);
            operation.action(operationInfo[FRUIT_INDEX],
                    Integer.parseInt(operationInfo[AMOUNT_INDEX]));
        }
    }
}
