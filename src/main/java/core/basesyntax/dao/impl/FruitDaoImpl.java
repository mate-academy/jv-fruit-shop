package core.basesyntax.dao.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Map<String, Integer> getAllFruits() {
        return FruitStorage.fruits;
    }
}
