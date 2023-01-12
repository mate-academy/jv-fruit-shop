package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public int getData(String fruit) {
        return FruitStorage.storageFruits.get(fruit);
    }

    @Override
    public void putInData(String fruit, int quantity) {
        FruitStorage.storageFruits.put(fruit, quantity);
    }

    @Override
    public void updateData(String fruit, int newQuantity) {
        FruitStorage.storageFruits.put(fruit, newQuantity);
    }
}
