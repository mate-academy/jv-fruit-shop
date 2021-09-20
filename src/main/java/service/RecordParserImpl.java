package service;

import dao.RecordDao;
import dao.RecordDaoImpl;
import database.Database;
import model.Record;

import java.util.ArrayList;
import java.util.List;

public class RecordParserImpl implements RecordParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public void parseRecords(List<String> linesFromFile) {
        RecordDao recordDao = new RecordDaoImpl();
        List<Record> records = new ArrayList<>();
        for (String line: linesFromFile) {
            String[] recordData = line.split(SEPARATOR);
            String operationType = recordData[OPERATION_INDEX];
            String fruitName = recordData[FRUIT_INDEX];
            int amount = Integer.parseInt(recordData[AMOUNT_INDEX]);
            recordDao.addRecord(new Record(operationType, fruitName, amount));
        }
    }
}
