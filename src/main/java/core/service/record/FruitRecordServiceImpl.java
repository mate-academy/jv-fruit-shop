package core.service.record;

import core.exception.ValidationException;
import core.model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordServiceImpl implements FruitRecordService {

    @Override
    public List<FruitRecord> parserFruit(List<String> createList) {
        List<FruitRecord> fruitList = new ArrayList<>();
        Mapper<String, FruitRecord> recordMap = new FruitRecordMapperImpl();
        for (String record : createList) {
            try {
                fruitList.add(recordMap.map(record));
            } catch (ValidationException e) {
                throw new RuntimeException("Can't parse data " + "Exception: " + e);
            }
        }
        return fruitList;
    }
}
