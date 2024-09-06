package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements OperationHandler {
    public static final int DEFAULT_VALUE = 0;

    @Override
    public void handle(Map<String, Integer> inventory, FruitTransaction fruitTransaction) {
        inventory.put(fruitTransaction.getFruit(),
                inventory.getOrDefault(fruitTransaction.getFruit(), DEFAULT_VALUE)
                        + fruitTransaction.getQuantity());
    }
}
