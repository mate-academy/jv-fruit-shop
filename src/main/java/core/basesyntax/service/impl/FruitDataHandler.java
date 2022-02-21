package core.basesyntax.service.impl;

import core.basesyntax.service.DataHandler;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitDataHandler implements DataHandler {
    private static final String REGEX = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private final OperationStrategy operationStrategy;

    public FruitDataHandler(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processData(List<String> data) {
        for (String line : data) {
            String[] splitLine = line.split(REGEX);
            operationStrategy.getStrategy(
                    FruitTransaction.getOperation(splitLine[INDEX_OF_OPERATION]))
                    .makeOperation(splitLine[INDEX_OF_FRUIT],
                            Integer.parseInt(splitLine[INDEX_OF_QUANTITY]));

        }
    }
}
