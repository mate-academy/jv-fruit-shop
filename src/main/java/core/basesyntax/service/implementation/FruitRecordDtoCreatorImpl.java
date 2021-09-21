package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.FruitRecordDtoCreator;
import core.basesyntax.service.validator.RecordValidator;
import java.util.ArrayList;
import java.util.List;

public class FruitRecordDtoCreatorImpl implements FruitRecordDtoCreator {
    private static final String CSV_SEPARATOR = ",";
    private final FileReaderService fileReaderService;
    private final RecordValidator recordValidator;
    private final FruitRecordDtoParser fruitRecordDtoParser;

    public FruitRecordDtoCreatorImpl(FileReaderService fileReaderService,
                                     RecordValidator recordValidator,
                                     FruitRecordDtoParser fruitRecordDtoParser) {
        this.fileReaderService = fileReaderService;
        this.recordValidator = recordValidator;
        this.fruitRecordDtoParser = fruitRecordDtoParser;
    }

    @Override
    public List<FruitRecordDto> parseRecords(String fileName) {
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>();
        List<String> records = fileReaderService.getRecords(fileName);
        for (String record : records) {
            String[] recordData = record.split(CSV_SEPARATOR);
            recordValidator.checkRecord(recordData);
            FruitRecordDto fruitRecordDto = fruitRecordDtoParser.parseRecord(recordData);
            fruitRecordDtos.add(fruitRecordDto);
        }
        return fruitRecordDtos;
    }
}
