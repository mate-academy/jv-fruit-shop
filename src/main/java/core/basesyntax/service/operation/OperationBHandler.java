package core.basesyntax.service.operation;

import core.basesyntax.FruitShop;

public class OperationBHandler implements OperationHandler {
    @Override
    public void process(String fruitName, int fruitQuantity) {
        FruitShop.FRUIT_WAREHOUSE.put(fruitName, fruitQuantity);
    }
}
