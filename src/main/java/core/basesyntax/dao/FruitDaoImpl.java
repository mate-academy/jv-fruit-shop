package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {

    @Override
    public Map<String, Integer> getFruitMap() {
        return Storage.FRUITS;
    }
}
