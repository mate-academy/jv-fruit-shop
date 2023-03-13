package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.getFruitShop().replace(fruit, Storage.getFruitShop().get(fruit)
                - quantity);
    }
}
