package strategy;

import model.Operation;
import java.util.Map;

public class FruitStrategy {
    private final Map<Operation, OperationService> operationServiceMap;

    public FruitStrategy(Map<Operation, OperationService> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    public void executeOperationServiceByOperation(Operation operation,
                                                   String fruitName, int quantity) {
        if (operation != null) {
            OperationService operationService = operationServiceMap.get(operation);
            operationService.execute(fruitName, quantity);
        } else {
            throw new RuntimeException("No such strategy");
        }
    }

}
