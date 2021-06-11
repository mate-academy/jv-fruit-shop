package core.basesyntax.service.operation;

import core.basesyntax.FruitShop;

public class BalanceHandler implements OperationHandler {
    @Override
    public void process(String fruitName, int fruitQuantity) {
        FruitShop.fruitWarehouse.put(fruitName, fruitQuantity);
    }
}
