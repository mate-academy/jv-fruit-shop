package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.validator.RecordValidator;
import java.util.ArrayList;
import java.util.List;

public class RecordParserServiceImpl implements RecordParserService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final String CSV_SEPARATOR = ",";
    private final FileReaderService fileReaderService;
    private final RecordValidator recordValidator;

    public RecordParserServiceImpl(FileReaderService fileReaderService,
                                   RecordValidator recordValidator) {
        this.fileReaderService = fileReaderService;
        this.recordValidator = recordValidator;
    }

    @Override
    public List<FruitRecord> parseRecords(String fileName) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        List<String> records = fileReaderService.getRecords(fileName);
        for (String record : records) {
            FruitRecord fruitRecord = new FruitRecord();
            String[] recordData = record.split(CSV_SEPARATOR);
            recordValidator.checkRecord(recordData);
            fruitRecord.setTypeOfOperation(FruitRecord.Type
                    .valueOfLabel(recordData[OPERATION_TYPE_INDEX]));
            fruitRecord.setFruit(new Fruit(recordData[FRUIT_NAME_INDEX]));
            fruitRecord.setAmount(Integer.parseInt(recordData[FRUIT_AMOUNT_INDEX]));
            fruitRecords.add(fruitRecord);
        }
        return fruitRecords;
    }
}
