package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StorageService;

public interface ActivitiesHandler {
    void handleActivity(StorageService storage, FruitTransaction fruitTransaction);
}
