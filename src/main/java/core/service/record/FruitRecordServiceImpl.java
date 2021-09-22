package core.service.record;

import core.dao.Validator;
import core.dao.ValidatorImpl;
import core.exception.ValidationException;
import core.model.FruitRecord;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordServiceImpl implements FruitRecordService {
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int FRUIT_NAME_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;

    @Override
    public List<FruitRecord> parserFruit(List<String> createList) throws ValidationException {
        Validator validator = new ValidatorImpl();
        String[] result;
        List<FruitRecord> fruitList = new ArrayList<>();
        for (String record : createList) {
            result = record.split(",");
            validator.validate(record);
            fruitList.add(new FruitRecord(result[OPERATION_TYPE_COLUMN],
                    result[FRUIT_NAME_COLUMN], Integer.parseInt(result[QUANTITY_COLUMN])));
        }
        return fruitList;
    }
}
