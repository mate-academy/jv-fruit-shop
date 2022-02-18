package fruitshop.strategy;

import fruitshop.model.Operation;
import java.util.Map;

public class OperationStrategy {
    private Map<Operation, OperationHandler> operationsMap;

    public OperationStrategy(Map<Operation, OperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    public Map<Operation, OperationHandler> get() {
        return operationsMap;
    }
}
