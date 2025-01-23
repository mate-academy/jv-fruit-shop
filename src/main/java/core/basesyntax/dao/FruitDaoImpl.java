package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.models.Fruit;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<Fruit> getAll() {
        return Storage.fruitStorage;
    }
}
