package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.HashMap;

public class Storage {
    private final HashMap<String,Integer> fruits;
    private final HashMap<FruitTransaction.Operation, OperationStrategy> operationMap;

    private Storage() {
        this.fruits = new HashMap<>();
        this.operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
    }

    public static Storage of() {
        return new Storage();
    }

    public HashMap<FruitTransaction.Operation, OperationStrategy> getOperationMap() {
        return operationMap;
    }

    public HashMap<String, Integer> getFruits() {
        return fruits;
    }

    public int getFruitCount(String fruit) {
        return fruits.get(fruit);
    }

    public void setFruits(String fruit, int quantity) {
        fruits.put(fruit, quantity);
    }
}
