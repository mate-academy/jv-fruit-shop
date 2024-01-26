package core.basesyntax.service.activitieswithfruitservice;

import core.basesyntax.model.FruitTransaction;

public interface ActivitiesStrategy {
    void performTransaction(String code, FruitTransaction fruitTransaction);
}
