package core.basesyntax.stategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyOperation implements FruitOperationHandler {
    @Override
    public void executeOperation(FruitTransaction fruitTransaction,
                                 Map<String, Integer> inventory) {
        validateQuantity(fruitTransaction.getQuantity(), fruitTransaction.getFruit());
        inventory.put(fruitTransaction.getFruit(),
                inventory.getOrDefault(
                        fruitTransaction.getFruit(), 0) + fruitTransaction.getQuantity());
    }
}
