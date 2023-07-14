package core.basesyntax.db;

import core.basesyntax.model.Fruit;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Fruit fruit) {
        if (fruit == null) {
            throw new RuntimeException("Storage must contain only fruits");
        }
        Storage.fruits.add(fruit);
    }

    @Override
    public Fruit get(String name) {
        for (Fruit fruit: Storage.fruits) {
            if (fruit.getName().equals(name)) {
                return fruit;
            }
        }
        throw new RuntimeException("Storage don't contain " + name);
    }

    @Override
    public Fruit[] getAll() {
        return Storage.fruits.toArray(new Fruit[0]);
    }
}
