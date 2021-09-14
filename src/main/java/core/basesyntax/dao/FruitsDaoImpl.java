package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import core.basesyntax.model.FruitRecord;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {
    private static final List<FruitRecord> DATA_BASE = DataBase.db;

    @Override
    public boolean addRecord(FruitRecord newFruitRecord) {
        if (isRecordExists(newFruitRecord)) {
            return modifyRecord(newFruitRecord);
        }
        return DATA_BASE.add(newFruitRecord);
    }

    @Override
    public List<FruitRecord> getRecords() {
        return DATA_BASE;
    }

    @Override
    public FruitRecord getRecord(FruitRecord newFruitRecord) {
        for (FruitRecord record : DATA_BASE) {
            if (record.getName().equals(newFruitRecord.getName())) {
                return record;
            }
        }
        return new FruitRecord(0, newFruitRecord.getName(), newFruitRecord.getType());
    }

    @Override
    public boolean modifyRecord(FruitRecord newFruitRecord) {
        for (int i = 0; i < DATA_BASE.size(); i++) {
            FruitRecord record = DATA_BASE.get(i);
            if (record.getName().equals(newFruitRecord.getName())) {
                DATA_BASE.set(i, newFruitRecord);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isRecordExists(FruitRecord newFruitRecord) {
        for (FruitRecord record : DATA_BASE) {
            if (record.getName().equals(newFruitRecord.getName())) {
                return true;
            }
        }
        return false;
    }
}
