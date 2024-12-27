package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class ProcessDataImpl implements ProcessData {
    private final FruitStrategyImpl fruitStrategy;

    public ProcessDataImpl(FruitStrategyImpl fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public List<String> processData(List<String> enterList) {
        List<String> processedData = new ArrayList<>();
        for (String enter : enterList) {
            String[] split = enter.split(",");
            String operation = split[0];
            String fruitType = split[1];
            int amount = Integer.parseInt(split[2]);
            int updatedAmount = fruitStrategy.operation(operation, fruitType, amount);

            processedData.add(fruitType + "," + updatedAmount);
        }
        return processedData;
    }
}
