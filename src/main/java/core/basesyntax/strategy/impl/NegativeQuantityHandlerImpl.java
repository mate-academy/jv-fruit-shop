package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.QuantityHandler;

public class NegativeQuantityHandlerImpl implements QuantityHandler {
    @Override
    public Integer getQuantity(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new RuntimeException("FruitTransaction cannot be null");
        }
        if (fruitTransaction.getFruit() == null) {
            throw new RuntimeException("Fruit cannot be null");
        }
        if (fruitTransaction.getFruit().getName() == null) {
            throw new RuntimeException("Fruit name cannot be null");
        }
        return -fruitTransaction.getFruit().getQuantity();
    }
}
