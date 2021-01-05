package core.basesyntax.service;

import core.basesyntax.dao.Warehouse;
import core.basesyntax.model.Fruit;

public interface Validation {

    static void isValid(Warehouse warehouse, Fruit fruit, int amount) {
        if (amount < 0) {
            throw new RuntimeException("Amount can't be less as zero, check the report");
        }
        if (warehouse.getAmountOfItem(fruit) - amount < 0) {
            throw new RuntimeException(fruit.getName()
                    + " is not enough in warehouse, check the report");
        }
    }
}
