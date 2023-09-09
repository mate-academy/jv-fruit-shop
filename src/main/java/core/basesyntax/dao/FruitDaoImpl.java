package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitInStorage;
import java.util.Collection;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(FruitInStorage product) {
        Storage.FRUITS.put(product.getName(), product);
    }

    @Override
    public FruitInStorage getByName(String name) {
        return Storage.FRUITS.get(name);
    }

    @Override
    public void update(FruitInStorage product, int amount) {
        product.setAmount(amount);
        Storage.FRUITS.put(product.getName(), product);
    }

    @Override
    public Collection<FruitInStorage> getAll() {
        return Storage.FRUITS.values();
    }
}
