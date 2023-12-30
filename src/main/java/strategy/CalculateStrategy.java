package strategy;

import dao.Storage;
import java.util.EnumMap;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;

public class CalculateStrategy implements Strategy {
    private final Storage storage;
    private Map<Operation, FruitOperation> operationMap;

    public CalculateStrategy(Storage storage) {
        this.storage = storage;
        this.operationMap = initializeOperationMap(storage);
    }

    private Map<Operation, FruitOperation> initializeOperationMap(Storage storage) {
        Map<Operation, FruitOperation> map = new EnumMap<>(Operation.class);
        map.put(Operation.BALANCE, new BalanceOperation(storage));
        map.put(Operation.SUPPLY, new SupplyReturnOperation(storage));
        map.put(Operation.RETURN, new SupplyReturnOperation(storage));
        map.put(Operation.PURCHASE, new PurchaseOperation(storage));
        return map;
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
