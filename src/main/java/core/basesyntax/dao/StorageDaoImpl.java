package core.basesyntax.dao;

import core.basesyntax.db.FruitShopStorage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class StorageDaoImpl implements StorageDao {

    @Override
    public void addFruit(Fruit fruit) {
        FruitShopStorage.storageFruits.add(fruit);
    }

    @Override
    public Fruit getFruit(String nameFruit) {
        try {
            return FruitShopStorage.storageFruits.stream()
                    .filter(f -> f.getName().equals(nameFruit))
                    .findFirst().get();
        } catch (RuntimeException e) {
            throw new RuntimeException("This fruit is not in storage" + nameFruit, e);
        }
    }

    @Override
    public List<Fruit> getAll() {
        return FruitShopStorage.getStorageFruits();
    }
}
