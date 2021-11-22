package core.dao;

import core.exception.ValidationException;
import core.model.FruitRecord;
import java.util.List;

public interface FruitRecordDao {
    void add(FruitRecord fruitRecord);

    List<FruitRecord> parseFruitRecords(List<String> rawRecords) throws ValidationException;

}
