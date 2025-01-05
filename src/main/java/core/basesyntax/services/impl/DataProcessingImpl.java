package core.basesyntax.services.impl;

import core.basesyntax.Operation;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.services.DataProcessing;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<String> processData(List<String> enterList) {
        enterList.forEach(enter -> {
            String[] split = enter.split(COMMA);
            String operation = split[OPERATION_TYPE];
            String fruitType = split[FRUIT_TYPE];
            int amount = Integer.parseInt(split[AMOUNT]);

            OperationHandler handler = fruitStrategy
                    .getOperationHandler(Operation.getOperation(operation));
            handler.apply(fruitType, amount);
        });

        return storage.getStorage().entrySet().stream()
                .map(entry -> entry.getKey() + COMMA + entry.getValue())
                .collect(Collectors.toList());
    }
}
        /*List<String> processedData = new ArrayList<>();
        for (String enter : enterList) {
            String[] split = enter.split(COMMA);
            String operation = split[OPERATION_TYPE];
            String fruitType = split[FRUIT_TYPE];
            int amount = Integer.parseInt(split[AMOUNT]);

            OperationHandler handler = fruitStrategy
            .getOperationHandler(Operation.getOperation(operation));
            int updatedAmount = handler.apply(fruitType, amount);
            storage.put(fruitType, updatedAmount);
        }
        for (String enter : enterList) {
            String[] split = enter.split(COMMA);
            String fruitType = split[FRUIT_TYPE];
            int currentAmount = storage.getCurrentAmount(fruitType);
            processedData.add(fruitType + COMMA + currentAmount);
        }
        List<String> collect = processedData.stream()
                .distinct()
                .collect(Collectors.toList());
        return collect;
   }*/
// What is better to use?
