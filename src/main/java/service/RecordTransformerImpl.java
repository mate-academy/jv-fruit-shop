package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import java.util.List;
import model.Record;
import validation.RecordValidatorImpl;

public class RecordTransformerImpl implements RecordTransformer {
    private static final String SEPARATOR = ",";
    private static final int ACTIVITY_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void transform(List<String> stringRecords) {
        RecordDao recordDao = new RecordDaoImpl();
        for (String string: stringRecords) {
            String[] recordData = string.split(SEPARATOR);
            RecordValidatorImpl recordValidator = new RecordValidatorImpl();
            recordValidator.isValidInput(recordData);
            String activityType = recordData[ACTIVITY_INDEX];
            String fruitName = recordData[FRUIT_INDEX];
            int amount = Integer.parseInt(recordData[AMOUNT_INDEX]);
            recordDao.add(new Record(activityType, fruitName, amount));
        }
    }
}
