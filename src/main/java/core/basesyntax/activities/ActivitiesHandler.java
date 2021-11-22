package core.basesyntax.activities;

import core.basesyntax.dao.FruitsDao;

public interface ActivitiesHandler {
    void doActivity(String name, int quantity, FruitsDao storageDao);
}
