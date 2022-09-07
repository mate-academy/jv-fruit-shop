package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

public interface Supply {
    /**
     *  Add some amount of some fruits from storage
     */
    void add (Fruit fruitType, Integer amount);
}
