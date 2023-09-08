package fruite.store.service.strategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyHandler {
    public static final Map<String, OperationHandler> operationTypeStrategy = new HashMap<>();

    public void doSpecialOperationOnFruits(String type, String fruit, String quantity) {
        Integer intQuantity = Integer.parseInt(quantity);
        for (Map.Entry<String, OperationHandler> entry : operationTypeStrategy.entrySet()) {
            if (entry.getKey().equals(type)) {
                entry.getValue().doOperation(fruit, intQuantity);
                return;
            }
        }
        throw new RuntimeException("Unknown operation: " + type);
    }
}
