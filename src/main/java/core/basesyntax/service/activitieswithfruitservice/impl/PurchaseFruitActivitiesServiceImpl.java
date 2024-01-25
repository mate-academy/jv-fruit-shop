package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.ActivitiesWithFruitService;

public class PurchaseFruitActivitiesServiceImpl implements ActivitiesWithFruitService {
    @Override
    public void activitiesWithFruit(FruitTransaction fruitTransaction) {
        Integer totalFruitInStorage = Storage.fruitStorage.get(fruitTransaction.getFruit());
        Integer fruitInStorageAfterPurchase = totalFruitInStorage - fruitTransaction.getQuantity();
        Storage.fruitStorage.replace(fruitTransaction.getFruit(), fruitInStorageAfterPurchase);
    }
}
