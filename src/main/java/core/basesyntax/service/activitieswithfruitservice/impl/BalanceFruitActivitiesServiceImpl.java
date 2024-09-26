package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesWithFruitService;

public class BalanceFruitActivitiesServiceImpl implements ActivitiesWithFruitService {
    @Override
    public void performTransaction(FruitTransaction fruitTransaction) {
        Storage.fruitStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
