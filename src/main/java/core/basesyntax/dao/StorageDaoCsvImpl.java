package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitCrate;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoCsvImpl implements StorageDao {
    @Override
    public FruitCrate update(FruitCrate fruitCrate) {
        if (get(fruitCrate.getName()) == null) {
            Storage.storage.add(fruitCrate);
        } else {
            int newQuantity = fruitCrate.getQuantity() + get(fruitCrate.getName()).getQuantity();
            get(fruitCrate.getName()).setQuantity(newQuantity);
        }
        return get(fruitCrate.getName());
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
}
