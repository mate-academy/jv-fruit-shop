package core.service;

import java.util.List;

public class FruitTransactionProcessorServiceImpl implements FruitTransactionProcessorService {
    private final OperationHandlerStrategy operationHandlerStrategy;
    private final int OPERATION_POS = 0;
    private final int FRUIT_NAME_POS = 1;
    private final int FRUITS_QUANTITY_POS = 2;

    public FruitTransactionProcessorServiceImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    public void fillStorage(List<String> lines) {
        for (String line : lines) {
            try {
                line = line.trim();
                String[] operationData = line.split(",");
                String operation = operationData[OPERATION_POS];
                String fruitName = operationData[FRUIT_NAME_POS];
                int fruitsQuantity = Integer.parseInt(operationData[FRUITS_QUANTITY_POS]);
                operationHandlerStrategy.get(operation).handle(fruitName,fruitsQuantity);
            } catch (NumberFormatException
                     | NullPointerException e) {
                continue;
            }
        }
    }
}
