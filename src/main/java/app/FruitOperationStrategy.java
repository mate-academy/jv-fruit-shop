package app;

import app.service.Operation;
import app.service.impl.OperationBuy;
import app.service.impl.OperationReturn;
import app.service.impl.OperationSupply;
import java.util.HashMap;
import java.util.Map;

public class FruitOperationStrategy {
    private static Map<String, Operation> fruitOperations;

    public FruitOperationStrategy() {
        fruitOperations = new HashMap<>();
    }

    public Operation getOperation(String operationName) {
        fillMapOfOperators();
        Operation resultOperation = fruitOperations.get(operationName);
        if (resultOperation == null) {
            throw new RuntimeException("Cant find correct operation for type: " + operationName);
        }
        return resultOperation;
    }

    private static void fillMapOfOperators() {
        fruitOperations.put("s",new OperationSupply());
        fruitOperations.put("b", new OperationBuy());
        fruitOperations.put("r", new OperationReturn());
    }
}
