package core.basesyntax.service;

import core.basesyntax.dao.Warehouse;

public interface Validation {

    static boolean isValid(Warehouse warehouse, String name, int amount) {
        if (amount < 0) {
            return false;
        }
        return warehouse.getAmountOfFruit(name) - amount >= 0;
    }
}
