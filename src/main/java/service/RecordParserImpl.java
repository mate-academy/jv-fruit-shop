package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import java.util.List;
import model.Record;
import validation.InputValidator;
import validation.InputValidatorImpl;

public class RecordParserImpl implements RecordParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void parseRecords(List<String> linesFromFile) {
        RecordDao recordDao = new RecordDaoImpl();
        for (String line: linesFromFile) {
            String[] recordData = line.split(SEPARATOR);
            InputValidator inputValidator = new InputValidatorImpl();
            inputValidator.isValidInput(recordData);
            String operationType = recordData[OPERATION_INDEX];
            String fruitName = recordData[FRUIT_INDEX];
            int amount = Integer.parseInt(recordData[AMOUNT_INDEX]);
            recordDao.addRecord(new Record(operationType, fruitName, amount));
        }
    }
}
