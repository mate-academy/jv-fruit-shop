package dao;

import database.Database;
import java.util.List;
import model.Record;

public class RecordDaoImpl implements RecordDao {

    @Override
    public void addRecord(Record record) {
        Database.RECORDS.add(record);
    }

    @Override
    public List<Record> getRecords() {
        return Database.RECORDS;
    }
}
