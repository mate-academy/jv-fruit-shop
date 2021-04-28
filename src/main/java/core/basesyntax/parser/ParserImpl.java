package core.basesyntax.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.store.record.FruitRecordService;
import core.basesyntax.validator.Validator;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final String CSV_SEPARATOR = ",";
    Validator validator;
    FruitRecordService fruitRecordService;

    public ParserImpl(Validator validator,
                      FruitRecordService fruitRecordService) {
        this.validator = validator;
        this.fruitRecordService = fruitRecordService;
    }

    @Override
    public List<FruitRecord> parseLines(List<String> lines) {
        int lineNumber = 1;
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (String line : lines) {
            String[] splitedLine = line.split(CSV_SEPARATOR);
            validator.lineValidator(splitedLine, lineNumber);
            fruitRecords.add(fruitRecordService.createNewFruitRecord(
                    new Fruit(splitedLine[1], Long.parseLong(splitedLine[2])),
                    OperationType.valueOf(splitedLine[0].toUpperCase())));
        }
        return fruitRecords;
    }
}
