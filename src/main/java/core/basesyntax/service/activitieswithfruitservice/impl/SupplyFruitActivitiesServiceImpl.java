package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesWithFruitService;

public class SupplyFruitActivitiesServiceImpl implements ActivitiesWithFruitService {
    @Override
    public void performTransaction(FruitTransaction fruitTransaction) {
        Integer totalFruitInStorage = Storage.fruitStorage.get(fruitTransaction.getFruit());
        Integer supplyPlusInStorageFruits = totalFruitInStorage + fruitTransaction.getQuantity();
        Storage.fruitStorage.replace(fruitTransaction.getFruit(), supplyPlusInStorageFruits);
    }
}
