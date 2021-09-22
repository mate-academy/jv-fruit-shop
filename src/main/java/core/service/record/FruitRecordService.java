package core.service.record;

import core.exception.ValidationException;
import core.model.FruitRecord;
import java.util.List;

public interface FruitRecordService {
    void add(FruitRecord fruitRecord);

    void save(List<FruitRecord> fruitRecordList);

    List<FruitRecord> parserFruit(List<String> createList) throws ValidationException;
}
