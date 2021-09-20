package core.basesyntax.dao;

import core.basesyntax.db.DataBase;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {
    private static final List<FruitRecord> DATABASE = DataBase.DB;

    @Override
    public boolean addRecord(FruitRecord newFruitRecord) {
        return DATABASE.add(newFruitRecord);
    }

    @Override
    public List<FruitRecord> getRecords() {
        return DATABASE;
    }

    @Override
    public List<FruitRecord> getRecord(Fruit desiredFruit) {
        List<FruitRecord> foundRecords = new ArrayList<>();
        for (FruitRecord record : DATABASE) {
            if (record.getFruit().equals(desiredFruit)) {
                foundRecords.add(record);
            }
        }
        return foundRecords;
    }

    @Override
    public boolean updateRecord(FruitRecord desiredRecord) {
        for (int i = 0; i < DATABASE.size(); i++) {
            FruitRecord recordFromDB = DATABASE.get(i);
            if (recordFromDB.getFruit().equals(desiredRecord.getFruit())) {
                DATABASE.set(i, desiredRecord);
                return true;
            }
        }
        return false;
    }
}
