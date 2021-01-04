package core.basesyntax.service;

import core.basesyntax.dao.Warehouse;

public interface Validation {

    static boolean isValid(Warehouse warehouse, String name, int amount) {
        if (amount < 0) {
            throw new RuntimeException("Amount can't be less as zero, check the report");
        }
        if (warehouse.getAmountOfItem(name) - amount < 0) {
            throw new RuntimeException(name + " is not enough in warehouse, check the report");
        }
        return true;
    }
}
