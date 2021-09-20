package dao;

import database.Database;
import model.Record;

import java.util.List;

public interface RecordDao {
    void addRecord(Record record);
    List<Record> getRecords();
}
