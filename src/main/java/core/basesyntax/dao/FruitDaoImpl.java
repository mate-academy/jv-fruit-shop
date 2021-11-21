package core.basesyntax.dao;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.storage.add(fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.storage.stream()
                .filter(s -> s.getFruitName().equals(fruitName))
                .findFirst()
                .get();
    }
}
