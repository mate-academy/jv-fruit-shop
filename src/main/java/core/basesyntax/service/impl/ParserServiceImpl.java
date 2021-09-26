package core.basesyntax.service.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FruitOperationValidator;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements DataParserService<FruitRecord, String> {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitRecord> parseData(List<String> data) {
        FruitOperationValidator fruitOperationValidator = new FruitOperationValidatorImpl();
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (String line : data) {
            String[] tmp = line.split(COMMA);
            fruitOperationValidator.validate(tmp);
            fruitRecords.add(new FruitRecord(FruitRecord.Operation.get(tmp[TYPE]), tmp[FRUIT],
                    Integer.parseInt(tmp[AMOUNT])));
        }
        return fruitRecords;
    }
}
