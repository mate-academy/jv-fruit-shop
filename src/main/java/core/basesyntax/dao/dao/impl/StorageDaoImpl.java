package core.basesyntax.dao.dao.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitModel;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public String addFruit(FruitModel fruitModel, Integer amount) {
        for (Map.Entry<FruitModel, Integer> entry : Storage.fruitStorage.entrySet()) {
            if (entry.getKey().equals(fruitModel)) {
                int newAmount = entry.getValue() + amount;
                entry.setValue(newAmount);
                return fruitModel + " amount was updated: " + Storage.fruitStorage.get(fruitModel);
            }
        }
        Storage.fruitStorage.put(fruitModel, amount);
        return fruitModel + " added to the storage. Amount: "
                + Storage.fruitStorage.get(fruitModel);
    }

    @Override
    public Integer getFruit(FruitModel fruitModel, int amount) {
        Integer currentAmount = Storage.fruitStorage.get(fruitModel);
        if (amount > currentAmount) {
            throw new IllegalArgumentException("There are not enough "
                    + "fruits in the storage. Current amount is: " + currentAmount);
        } else if (currentAmount == amount) {
            Storage.fruitStorage.remove(fruitModel);
            return currentAmount;
        } else {
            int newAmount = currentAmount - amount;
            Storage.fruitStorage.remove(fruitModel);
            Storage.fruitStorage.put(fruitModel, newAmount);
            return newAmount;
        }
    }
}
