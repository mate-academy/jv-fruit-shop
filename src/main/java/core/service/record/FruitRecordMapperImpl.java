package core.service.record;

import core.dao.Validator;
import core.dao.ValidatorImpl;
import core.exception.ValidationException;
import core.model.FruitRecord;

public class FruitRecordMapperImpl implements Mapper<String, FruitRecord> {
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int FRUIT_NAME_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private Validator validator = new ValidatorImpl();

    @Override
    public FruitRecord map(String record) throws ValidationException {
        String[] result;
        result = record.split(",");
        validator.validate(record);
        return new FruitRecord(result[OPERATION_TYPE_COLUMN],
                result[FRUIT_NAME_COLUMN], Integer.parseInt(result[QUANTITY_COLUMN]));
    }
}
