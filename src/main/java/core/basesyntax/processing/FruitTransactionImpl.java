package core.basesyntax.processing;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionImpl implements FruitTransaction {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public void processing(List<String> activities) {
        OperationStrategy operationStrategy = new OperationStrategy();
        for (int i = 1; i < activities.size(); i++) {
            String[] activityArray = activities.get(i).split(",");
            operationStrategy.getOperationHandler(activityArray[OPERATION])
                    .calculateFruitQuantity(activityArray[FRUIT],
                            Integer.parseInt(activityArray[QUANTITY]));
        }
    }
}
