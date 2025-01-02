package core.basesyntax.services.impl;

import core.basesyntax.services.DataProcessing;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.ArrayList;
import java.util.List;

public class DataProcessingImpl implements DataProcessing {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;
    private static final String COMMA = ",";
    private final FruitStrategyImpl fruitStrategy;

    public DataProcessingImpl(FruitStrategyImpl fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public List<String> processData(List<String> enterList) {
        List<String> processedData = new ArrayList<>();
        for (String enter : enterList) {
            String[] split = enter.split(COMMA);
            String operation = split[OPERATION_TYPE];
            String fruitType = split[FRUIT_TYPE];
            int amount = Integer.parseInt(split[AMOUNT]);

            int updatedAmount = fruitStrategy.operation(operation, fruitType, amount);
            processedData.add(fruitType + "," + updatedAmount);
        }
        return processedData;
    }
}
