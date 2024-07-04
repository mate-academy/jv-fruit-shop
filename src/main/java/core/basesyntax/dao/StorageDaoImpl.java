package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void addFruit(Fruit fruit) {
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit getFruit(String fruitName) {
        for (Fruit fruit : Storage.fruits) {
            if (fruit.getFruit().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    @Override
    public void update(String fruit, int newQuantity) {
        getFruit(fruit).setQuantity(newQuantity);
    }
}
