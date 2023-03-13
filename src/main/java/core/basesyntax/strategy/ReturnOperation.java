package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationStrategy {
    @Override
    public void execute(String fruit, int quantity) {
        Storage.getFruitShop().replace(fruit, quantity
                + Storage.getFruitShop().get(fruit));
    }
}
