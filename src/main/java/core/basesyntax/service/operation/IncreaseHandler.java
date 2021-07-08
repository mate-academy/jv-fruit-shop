package core.basesyntax.service.operation;

import core.basesyntax.FruitShop;

public class IncreaseHandler implements OperationHandler {
    @Override
    public void process(String fruitName, int fruitQuantity) {
        FruitShop.fruitWarehouse.put(
                fruitName, FruitShop.fruitWarehouse.getOrDefault(
                        fruitName, 0) + fruitQuantity);
    }
}
