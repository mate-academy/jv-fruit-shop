package app;

import app.service.Operation;
import java.util.List;
import java.util.Map;

public class FruitOperationStrategy {
    private Map<String, Operation> fruitOperations;

    public FruitOperationStrategy(Map<String, Operation> fruitOperations) {
        this.fruitOperations = fruitOperations;
    }

    public Operation getOperation(List<String> line) {
        Operation resultOperation = fruitOperations.get(line.get(0));
        if (resultOperation == null) {
            throw new RuntimeException("Cant find correct operation for type: " + line.get(0));
        }
        return resultOperation;
    }
}
