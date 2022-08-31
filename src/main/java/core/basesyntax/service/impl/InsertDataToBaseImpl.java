package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.InsertDataToBase;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.List;

public class InsertDataToBaseImpl implements InsertDataToBase {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;
    private final OperationHandlerStrategy operationHandlerStrategy;

    public InsertDataToBaseImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public void addTransferToStorage(List<String> dataFromBase) {
        String[] parsedData;
        Fruit fruit = new Fruit("");
        for (int i = 1; i < dataFromBase.size(); i++) {
            parsedData = dataFromBase.get(i).split(",");
            fruit.setName(parsedData[FRUIT_NAME]);
            if (!Storage.fruits.containsKey(fruit)) {
                Storage.fruits.put(fruit, Integer.parseInt(parsedData[QUANTITY]));
            } else {
                Storage.fruits.put(fruit, operationHandlerStrategy.get(parsedData[OPERATION])
                        .apply(Storage.fruits.get(fruit),
                                Integer.parseInt(parsedData[QUANTITY])));
            }
        }
    }
}
