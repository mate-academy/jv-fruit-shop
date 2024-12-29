package core.basesyntax;

import core.basesyntax.strategy.FruitStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessingImpl implements DataProcessing {
    private final FruitStrategyImpl fruitStrategy;
    private Map<String,Integer> map;
    private static final int CONSTANT_0 = 0;
    private static final int CONSTANT_1 = 1;
    private static final int CONSTANT_2 = 2;

    public DataProcessingImpl(FruitStrategyImpl fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
        map = new HashMap<>();
    }

    @Override
    public List<String> processData(List<String> enterList) {
        for (String enter : enterList) {
            String[] split = enter.split(",");
            String operation = split[CONSTANT_0];
            String fruitType = split[CONSTANT_1];
            int amount = Integer.parseInt(split[CONSTANT_2]);

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
