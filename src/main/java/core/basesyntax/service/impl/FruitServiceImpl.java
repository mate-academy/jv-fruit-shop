package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processDailyActivities(List<String> data) {
        for (String activity : data) {
            String operation = activity.split(",")[OPERATION_INDEX];
            String fruit = activity.split(",")[FRUIT_INDEX];
            String quantity = activity.split(",")[QUANTITY_INDEX];

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);

            OperationHandler operationHandler = operationStrategy.getOperationHandler(transaction);
            operationHandler.registerTransaction(transaction);
        }
    }
}
