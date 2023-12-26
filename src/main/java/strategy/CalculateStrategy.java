package strategy;

import db.Storage;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;

public class CalculateStrategy {
    private final Storage storage;
    private final Map<String, Integer> fruitQuantities;
    private final Map<Operation, FruitOperation> operationMap;

    public CalculateStrategy(Storage storage, Map<String, Integer> fruitQuantities) {
        this.storage = storage;
        this.fruitQuantities = fruitQuantities;

        operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceOperation());
        operationMap.put(Operation.SUPPLY, new SupplyReturnOperation());
        operationMap.put(Operation.RETURN, new SupplyReturnOperation());
        operationMap.put(Operation.PURCHASE, new PurchaseOperation());
    }

    public void setOperation(FruitTransaction fruitTransaction) {

        FruitOperation operation = operationMap.get(fruitTransaction.getOperation());
        if (operation == null) {
            throw new IllegalArgumentException("Unexpected operation: "
                    + fruitTransaction.getOperation());
        }
        operation.execute(storage, fruitQuantities, fruitTransaction);
    }
}
