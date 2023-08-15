package core.basesyntax.service.impl;

import core.basesyntax.InvalidTransactionException;
import core.basesyntax.db.FruitInventory;
import core.basesyntax.service.FruitInventoryManipulator;

public class FruitInventoryManipulatorImpl implements FruitInventoryManipulator {
    public Integer getValue(String fruit) {
        return FruitInventory.getInventory().get(fruit);
    }

    public void add(String fruit, int quantity) {
        Integer initialValue = getValue(fruit);
        int useValue = initialValue == null ? 0 : initialValue;
        FruitInventory.getInventory().put(fruit, useValue + quantity);
    }

    public void subtract(String fruit, int quantity) {
        int initialValue = FruitInventory.getInventory().get(fruit);
        validateValue(initialValue);
        if (initialValue < quantity) {
            throw new InvalidTransactionException("Not enough fruit in stock");
        }
        FruitInventory.getInventory().put(fruit, initialValue - quantity);
    }

    public void validateValue(Integer value) {
        if (value == null) {
            throw new InvalidTransactionException("Can't manipulate a non-existing position");
        }
    }
}
