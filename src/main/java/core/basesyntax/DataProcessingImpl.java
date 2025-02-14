package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProcessingImpl implements DataProcessingMet {
    private final OperationStrategy operationStrategy;

    public DataProcessingImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(List<String> fruits) {
        Map<String, Integer> result = new HashMap<>();

        for (String record : fruits) {
            String[] fruitInArr = record.split(",");
            String operation = fruitInArr[0];
            String name = fruitInArr[1];
            int quantity = Integer.parseInt(fruitInArr[2]);

            int currentQuantity = result.getOrDefault(name, 0);
            OperationHandler handler = operationStrategy.getOperation(operation);
            int newQuantity = handler.changeWarehouseStatus(operation, currentQuantity, quantity);

            result.put(name, newQuantity);
        }
        return result;
    }
}
