package core.basesyntax.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitModel;

public class StorageDaoImpl implements StorageDao {
    @Override
    public String addFruit(FruitModel fruitModel, int amount) {
        if (Storage.fruitStorage.containsKey(fruitModel)) {
            int newAmount = Storage.fruitStorage.get(fruitModel) + amount;
            Storage.fruitStorage.replace(fruitModel, newAmount);
            return fruitModel + " amount was updated: " + Storage.fruitStorage.get(fruitModel);
        } else {
            Storage.fruitStorage.put(fruitModel, amount);
        }
        return fruitModel + " added to the storage. Amount: "
                + Storage.fruitStorage.get(fruitModel);
    }

    @Override
    public Integer updateFruitAmount(FruitModel fruitModel, int amount) {
        Integer currentAmount = Storage.fruitStorage.get(fruitModel);
        if (amount > currentAmount) {
            throw new IllegalArgumentException("There are not enough "
                    + "fruits in the storage. Current amount is: " + currentAmount);
        }
        int newAmount = currentAmount - amount;
        Storage.fruitStorage.put(fruitModel, newAmount);
        return newAmount;
    }
}
