package dao;

import model.FruitModel;
import storage.FruitStorage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int getAmount(String key) {
        return FruitStorage.fruitStorage.get(key);
    }

    @Override
    public boolean putFruitModel(FruitModel fruitModel) {
        FruitStorage.fruitStorage.put(fruitModel.getName(), fruitModel.getAmount());
        return true;
    }

    @Override
    public boolean replaceWithNewAmount(String name, int amount) {
        FruitStorage.fruitStorage.replace(name, amount);
        return true;
    }

    @Override
    public boolean containsKey(String key) {
        return FruitStorage.fruitStorage.containsKey(key);
    }
}
