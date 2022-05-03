package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.activity.OperationHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitTransactionImpl implements FruitTransaction {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    @Override
    public void processTransaction(List<String> listFromFile,
                            Map<Operation, OperationHandler> activityServiceMap) {
        for (int i = 1; i < listFromFile.size(); i++) {
            String[] line = listFromFile.get(i).split(",");
            Operation operation = Operation.getOperation(line[OPERATION_INDEX]);
            Fruit fruit = new CreateFruitImpl()
                    .createFruit(line[FRUIT_NAME_INDEX], line[FRUIT_AMOUNT_INDEX]);
            new OperationStrategyImpl(activityServiceMap)
                    .get(operation)
                    .handle(fruit);
        }
    }
}
