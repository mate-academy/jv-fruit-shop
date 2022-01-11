package dao;

import db.Storage;
import java.util.List;
import model.Record;

public class RecordDaoImpl implements RecordDao {
    @Override
    public void add(Record record) {
        Storage.RECORD_LIST.add(record);
    }

    @Override
    public List<Record> getRecord() {
        return Storage.RECORD_LIST;
    }
}
