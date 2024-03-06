package strategy.impl;

import model.FruitTransaction;
import model.Operation;
import strategy.OperationService;
import java.util.List;
import java.util.Map;

public class FruitStrategy {
    private final Map<Operation, OperationService> operationServiceMap;

    public FruitStrategy(Map<Operation, OperationService> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    public void executeOperationServiceByOperation(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation() != null) {
                OperationService operationService = operationServiceMap.get(transaction.getOperation());
                operationService.execute(transaction.getFruit(), transaction.getQuantity());
            } else {
                throw new RuntimeException("No such strategy");
            }
        }
    }
}
