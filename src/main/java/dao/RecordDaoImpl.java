package dao;

import database.Database;
import model.Record;

import java.util.List;

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
