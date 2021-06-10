package core.basesyntax.service.operation;

import core.basesyntax.FruitShop;

public class OperationRHandler implements OperationHandler {
    @Override
    public void process(String fruitName, int fruitQuantity) {
        FruitShop.FRUIT_WAREHOUSE.put(
                fruitName, FruitShop.FRUIT_WAREHOUSE.getOrDefault(
                        fruitName, 0) + fruitQuantity);
    }
}
