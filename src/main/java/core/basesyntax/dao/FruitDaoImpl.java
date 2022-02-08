package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import core.basesyntax.model.FruitRecord;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
    private static final List<FruitRecord> DATABASE = DataBase.DB;

    @Override
    public boolean addRecord(FruitRecord newFruitRecord) {
        return DATABASE.add(newFruitRecord);
    }

    @Override
    public List<FruitRecord> getRecords() {
        return DATABASE;
    }
}
