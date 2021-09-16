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
            if (record.getFruit().equals(newFruitRecord.getFruit())) {
                return record;
            }
        }
        return new FruitRecord(0, newFruitRecord.getFruit(), newFruitRecord.getType());
    }

    @Override
    public boolean modifyRecord(FruitRecord newFruitRecord) {
        for (int i = 0; i < DATA_BASE.size(); i++) {
            FruitRecord record = DATA_BASE.get(i);
            if (record.getFruit().equals(newFruitRecord.getFruit())) {
                DATA_BASE.set(i, newFruitRecord);
                return true;
            }
        }
        return false;
    }

    private boolean isRecordExists(FruitRecord newFruitRecord) {
        for (FruitRecord record : DATA_BASE) {
            if (record.getFruit().equals(newFruitRecord.getFruit())) {
                return true;
            }
        }
        return false;
    }
}
