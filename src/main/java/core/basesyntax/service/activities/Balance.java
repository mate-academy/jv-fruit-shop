package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface Balance {
    /**
     * return the remnants of fruits at the beginning of the working day
     */
    List<Fruit> beginBalance();
}
