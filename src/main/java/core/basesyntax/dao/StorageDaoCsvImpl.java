package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitCrate;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoCsvImpl implements StorageDao {
    @Override
    public FruitCrate add(FruitCrate fruitCrate) {
        Storage.storage.add(fruitCrate);
        return get(fruitCrate.getName());
    }

    @Override
    public FruitCrate update(String fruitName, int quantity) {
        FruitCrate undatedFruitCrate = get(fruitName);
        undatedFruitCrate.setQuantity(quantity);
        return get(fruitName);
    }

    @Override
    public FruitCrate get(String fruitName) {
        return Storage.storage.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<FruitCrate> getAll() {
        return new ArrayList<>(Storage.storage);
    }

    @Override
    public FruitCrate remove(String fruitName) {
        FruitCrate fruitCrateToRemove = get(fruitName);
        if (fruitCrateToRemove != null) {
            Storage.storage.remove(fruitCrateToRemove);
        }
        return fruitCrateToRemove;
    }
}
