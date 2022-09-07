package core.basesyntax.service.activities;

import core.basesyntax.model.Fruit;

public interface Return {
    /**
     * return some amount of fruis back to storage
     */
    void returnFruits (Fruit fryitType, Integer amount);
}
