package strategy;

import dao.Storage;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;

public class CalculateStrategy implements Strategy {
    private final Storage storage;
    private final Map<Operation, FruitOperation> operationMap;

    public CalculateStrategy(Storage storage, Map<Operation, FruitOperation> operationMap) {
        this.storage = storage;
        this.operationMap = operationMap;
    }

    public void processTransaction(FruitTransaction fruitTransaction) {
        FruitOperation operation = operationMap.get(fruitTransaction.getOperation());
        if (operation == null) {
            throw new IllegalArgumentException("Unexpected operation: "
                    + fruitTransaction.getOperation());
        }
        operation.execute(fruitTransaction);
    }
}
