package core.basesyntax.model;

import core.basesyntax.db.Storage;
import core.basesyntax.service.strategy.BalanceOperationStrategy;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.PurchaseOperationStrategy;
import core.basesyntax.service.strategy.ReturnOperationStrategy;
import core.basesyntax.service.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    protected String fruit;
    protected int quantity;
    private Operation operation;

    public FruitTransaction(Operation operation, String fruit, int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public static Map<String, OperationStrategy> createOperationStrategies(Storage storage) {
        Map<String, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceOperationStrategy(storage));
        operationStrategies.put("s", new SupplyOperationStrategy(storage));
        operationStrategies.put("p", new PurchaseOperationStrategy(storage));
        operationStrategies.put("r", new ReturnOperationStrategy(storage));
        return operationStrategies;
    }
}

