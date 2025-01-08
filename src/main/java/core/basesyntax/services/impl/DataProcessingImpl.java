package core.basesyntax.services.impl;

import core.basesyntax.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.services.DataProcessing;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProcessingImpl implements DataProcessing {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;
    private static final String COMMA = ",";
    private final OperationStrategy fruitStrategy;
    private Storage storage;

    public DataProcessingImpl(OperationStrategyImpl fruitStrategy, Storage storage) {
        this.fruitStrategy = fruitStrategy;
        this.storage = storage;
    }

    @Override
    public List<FruitTransaction> processData(List<String> enterList) {
        List<FruitTransaction> list = new ArrayList<>();
        enterList.forEach(enter -> {
            String[] split = enter.split(COMMA);
            String operation = split[OPERATION_TYPE];
            String fruitType = split[FRUIT_TYPE];
            int amount = Integer.parseInt(split[AMOUNT]);

            OperationHandler handler = fruitStrategy
                    .getOperationHandler(Operation.getOperation(operation));
            handler.apply(fruitType, amount);
        });
        Map<String, Integer> storage1 = storage.getStorage();
        for (Map.Entry<String, Integer> entry : storage1.entrySet()) {
            Integer i = storage1.get(entry.getKey());
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setQuantity(i);
            fruitTransaction.setFruit(entry.getKey());
            list.add(fruitTransaction);
        }
        return list;
    }
}
