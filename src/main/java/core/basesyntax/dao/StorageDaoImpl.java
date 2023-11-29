package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    private static final Storage storage = new Storage();

    @Override
    public void add(Fruit fruit) {
        storage.getListOfFruits().add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return storage.getListOfFruits().stream()
                .filter(fruit -> fruit.getName().equals(fruitName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Fruit> getList() {
        return storage.getListOfFruits();
    }

    @Override
    public void update(Fruit fruit) {
        Fruit fruitFromDb = get(fruit.getName());
        storage.getListOfFruits().remove(fruitFromDb);
        add(fruit);
    }

    @Override
    public int size() {
        return storage.getListOfFruits().size();
    }
}
