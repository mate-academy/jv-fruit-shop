package core.basesyntax.service.activitieswithfruitservice;

import core.basesyntax.model.FruitTransaction;

public interface ActivitiesStrategy {
    void getActivitiesWithFruit(String code, FruitTransaction fruitTransaction);
}
