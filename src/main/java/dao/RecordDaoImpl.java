package dao;

import db.Storage;
import java.util.List;
import model.Record;

public class RecordDaoImpl implements RecordDao {
    @Override
    public void add(Record record) {
        Storage.records.add(record);
    }

    @Override
    public List<Record> getRecord() {
        return Storage.records;
    }
}
