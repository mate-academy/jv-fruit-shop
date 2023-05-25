package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ActivityService {
    void getAllActivitiesInTheShop(List<FruitTransaction> transactions);
}
