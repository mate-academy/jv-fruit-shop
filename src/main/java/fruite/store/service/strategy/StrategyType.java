package fruite.store.service.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyType {
    public static final Map<String, OperationType> operationTypeStrategy = new HashMap<>();

    public void doSpecialOperationOnFruits(String type, String fruit, String quantity) {
        Integer intQuantity = Integer.parseInt(quantity);
        for (Map.Entry<String, OperationType> entry : operationTypeStrategy.entrySet()) {
            if (entry.getKey().equals(type)) {
                entry.getValue().doOpearation(fruit, intQuantity);
                return;
            }
        }
        throw new RuntimeException("Unknown operation: " + type);
    }
}
