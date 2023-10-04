package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exeption.QuantityIsNegativeException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int newQuantity = Storage.STORAGE_MAP.getOrDefault(fruit, DEFAULT_VALUE)
                - fruitTransaction.getQuantity();
        if (newQuantity < DEFAULT_VALUE) {
            throw new QuantityIsNegativeException("Quantity is negative for fruit: " + fruit);
        }
        Storage.STORAGE_MAP.compute(fruit, (key, value) -> value - fruitTransaction.getQuantity());
    }
}
