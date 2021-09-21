package core.basesyntax.service;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.validator.RecordValidator;
import java.util.ArrayList;
import java.util.List;

public class RecordsParserServiceImpl implements RecordsParserService {
    private static final String CSV_SEPARATOR = ",";
    private final FileReaderService fileReaderService;
    private final RecordValidator recordValidator;
    private final FruitParserService fruitParserService;

    public RecordsParserServiceImpl(FileReaderService fileReaderService,
                                    RecordValidator recordValidator,
                                    FruitParserService fruitParserService) {
        this.fileReaderService = fileReaderService;
        this.recordValidator = recordValidator;
        this.fruitParserService = fruitParserService;
    }

    @Override
    public List<FruitRecord> parseRecords(String fileName) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        List<String> records = fileReaderService.getRecords(fileName);
        for (String record : records) {
            String[] recordData = record.split(CSV_SEPARATOR);
            recordValidator.checkRecord(recordData);
            FruitRecord fruitRecord = fruitParserService.parseRecord(recordData);
            fruitRecords.add(fruitRecord);
        }
        return fruitRecords;
    }
}
