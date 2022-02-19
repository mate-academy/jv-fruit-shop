package dao;

import java.util.List;
import model.Record;

public interface RecordDao {
    void addRecord(Record record);

    List<Record> getRecords();
}
