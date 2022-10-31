package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageUpdateService;

public class StoragePurchaseServiceImpl implements StorageUpdateService {
    @Override
    public Fruit update(Fruit fruit, Integer amount) {
        if (!Storage.storage.containsKey(fruit)) {
            throw new RuntimeException("There is no such fruit in the shop: " + fruit);
        }
        Integer fruitsInTheShop = Storage.storage.get(fruit);
        if (fruitsInTheShop < amount) {
            throw new RuntimeException(String.format("Not enough fruits in the shop. "
                    + "There are %d but you asked %d of %s", fruitsInTheShop, amount, fruit));
        }
        Storage.storage.put(fruit, fruitsInTheShop - amount);
        return fruit;
    }
}
