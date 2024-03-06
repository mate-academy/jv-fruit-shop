package strategy.impl;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import strategy.OperationService;

public class FruitStrategy {
    private final Map<Operation, OperationService> operationMap;

    public FruitStrategy(Map<Operation, OperationService> operationMap) {
        this.operationMap = operationMap;
    }

    public void executeOperationServiceByOperation(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            if (transaction.getOperation() != null) {
                OperationService operationService = operationMap.get(transaction.getOperation());
                operationService.execute(transaction.getFruit(), transaction.getQuantity());
            } else {
                throw new RuntimeException("No such strategy");
            }
        }
    }
}
