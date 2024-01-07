package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class SupplyStrategy implements OperationStrategy {
    @Override
    public void apply(String fruit, int quantity, Storage storage) {
        int currentQuantity = storage.getFruitQuantities().get(fruit);
        storage.getFruitQuantities().put(fruit, currentQuantity + quantity);
    }

}
