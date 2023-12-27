package strategy;

import db.Storage;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;

public class CalculateStrategy {
    private final Storage storage;
    private FruitTransaction fruitTransaction;
    private final Map<Operation, FruitOperation> operationMap;

    public CalculateStrategy(Storage storage) {
        this.storage = storage;
        this.fruitTransaction = fruitTransaction;

        operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new BalanceOperation(fruitTransaction, storage));
        operationMap.put(Operation.SUPPLY, new SupplyReturnOperation(fruitTransaction, storage));
        operationMap.put(Operation.RETURN, new SupplyReturnOperation(fruitTransaction, storage));
        operationMap.put(Operation.PURCHASE, new PurchaseOperation(fruitTransaction, storage));
    }

    public void processTransaction(FruitTransaction fruitTransaction) {

        FruitOperation operation = operationMap.get(fruitTransaction.getOperation());
        if (operation == null) {
            throw new IllegalArgumentException("Unexpected operation: "
                    + fruitTransaction.getOperation());
        }
        operation.execute(storage, fruitTransaction);
    }
}
