package core.basesyntax.services.impl;

import core.basesyntax.services.DataProcessing;
import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessingImpl implements DataProcessing {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_TYPE = 1;
    private static final int AMOUNT = 2;
    private static final String COMMA = ",";
    private final FruitStrategyImpl fruitStrategy;
    private Map<String,Integer> map;

    public DataProcessingImpl(FruitStrategyImpl fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
        map = new HashMap<>();
    }

    @Override
    public List<String> processData(List<String> enterList) {
        for (String enter : enterList) {
            String[] split = enter.split(COMMA);
            String operation = split[OPERATION_TYPE];
            String fruitType = split[FRUIT_TYPE];
            int amount = Integer.parseInt(split[AMOUNT]);

            int updatedAmount = fruitStrategy.operation(operation, fruitType, amount);
            map.put(fruitType, updatedAmount);
        }

        List<String> processedData = new ArrayList<>();
        for (Map.Entry<String, Integer> mapDetail : map.entrySet()) {
            processedData.add(mapDetail.getKey() + "," + mapDetail.getValue());
        }
        return processedData;
    }
}
