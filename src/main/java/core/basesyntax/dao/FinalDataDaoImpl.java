package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class FinalDataDaoImpl implements FinalDataDao {
    @Override
    public void add(String fruit, Integer amount) {
        Storage.finalData.put(fruit, amount);
    }
}
