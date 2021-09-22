package core.service.record;

import core.dao.FruitRecordDao;
import core.dao.FruitRecordDaoImpl;
import core.dao.Validator;
import core.dao.ValidatorImpl;
import core.exception.ValidationException;
import core.model.FruitRecord;
import core.service.FruitRecordMapper;
import core.service.Mapper;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordServiceImpl implements FruitRecordService {
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int FRUIT_NAME_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;

    private FruitRecordDao fruitRecordDao = new FruitRecordDaoImpl();
    private Mapper<String, FruitRecord> fruitRecordMapper = new FruitRecordMapper();

    @Override
    public void add(FruitRecord fruitRecord) {
        fruitRecordDao.add(fruitRecord);
    }

    @Override
    public void save(List<FruitRecord> fruitRecordList) {
        int index = 0;
        for (FruitRecord record : fruitRecordList) {
            fruitRecordDao.add(fruitRecordList.get(index));
            index++;
        }
    }

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
