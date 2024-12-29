package core.basesyntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessData {
    private final FruitStrategyImpl fruitStrategy;
    private Map<String,Integer> map;

    public ProcessDataImpl(FruitStrategyImpl fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
        map = new HashMap<>();
    }

    @Override
    public List<String> processData(List<String> enterList) {
        for (String enter : enterList) {
            String[] split = enter.split(",");
            String operation = split[0];
            String fruitType = split[1];
            int amount = Integer.parseInt(split[2]);

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
