package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction fruit) {
        SHOP_SERVICE.removeFruits(fruit.getFruit(), fruit.getQuantity());
    }
}
