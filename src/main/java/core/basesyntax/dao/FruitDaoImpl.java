package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void addData(Map<String, Integer> statistics) {
        Storage.setShiftStatistics(statistics);
    }

    @Override
    public Map<String, Integer> getData() {
        return Storage.getShiftStatistics();
    }
}
