package dao;

import java.util.List;
import model.Record;

public interface RecordDao {
    void add(Record record);

    List<Record> getRecord();
}
