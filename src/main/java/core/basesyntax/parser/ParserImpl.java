package core.basesyntax.parser;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.model.OperationType;
import core.basesyntax.store.FruitService;
import core.basesyntax.store.FruitServiceImpl;
import core.basesyntax.store.StorageService;
import core.basesyntax.store.StorageServiceImpl;
import core.basesyntax.store.record.FruitRecordService;
import core.basesyntax.store.record.FruitRecordServiceImpl;
import core.basesyntax.store.strategy.TypeHandler;
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParserImpl implements Parser {
    private static final String CSV_SEPARATOR = ",";
    Validator validator;
    FruitRecordService fruitRecordService;
    FruitService fruitService;

    public ParserImpl(Validator validator,
                      FruitRecordService fruitRecordService,
                      FruitService fruitService) {
        this.validator = validator;
        this.fruitRecordService = fruitRecordService;
        this.fruitService = fruitService;
    }

    @Override
    public List<FruitRecord> parseLines(List<String> lines) {
        int lineNumber = 1;
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (String line : lines) {
            String[] splitedLine = line.split(CSV_SEPARATOR);
            validator.lineValidator(splitedLine, lineNumber);
            fruitRecords.add(fruitRecordService.createNewFruitRecord(
                    fruitService.makeFruit(
                            splitedLine[1], Long.parseLong(splitedLine[2])),
                    OperationType.valueOf(splitedLine[0].toUpperCase())));
        }
        return fruitRecords;
    }
}
