package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesWithFruitService;

public class ReturnFruitActivitiesServiceImpl implements ActivitiesWithFruitService {
    @Override
    public void performTransaction(FruitTransaction fruitTransaction) {
        Integer totalFruitInStorage = Storage.fruitStorage.get(fruitTransaction.getFruit());
        Integer returnPlusInStorageFruits = totalFruitInStorage + fruitTransaction.getQuantity();
        Storage.fruitStorage.replace(fruitTransaction.getFruit(), returnPlusInStorageFruits);
    }
}
