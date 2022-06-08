package core.service.impl;

import core.service.FruitTransactionProcessorService;
import core.strategy.OperationHandlerStrategy;
import java.util.List;

public class FruitTransactionProcessorServiceImpl implements FruitTransactionProcessorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUITS_QUANTITY_INDEX = 2;
    private final OperationHandlerStrategy operationHandlerStrategy;

    public FruitTransactionProcessorServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public void fillStorage(List<String> lines) {
        lines.remove(0);
        for (String line : lines) {
            String[] splittedLine = line.split(",");
            String operation = splittedLine[OPERATION_INDEX];
            String fruitName = splittedLine[FRUIT_NAME_INDEX];
            int fruitsQuantity = Integer.parseInt(splittedLine[FRUITS_QUANTITY_INDEX]);
            operationHandlerStrategy.get(operation).handle(fruitName,fruitsQuantity);
        }
    }
}
