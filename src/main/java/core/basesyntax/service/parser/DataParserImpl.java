package core.basesyntax.service.parser;

import core.basesyntax.dto.FruitRecordsDtoImpl;
import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String CSV_SEPARATOR = ",";
    private static final int TITLE_INDEX = 0;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitRecord> parseData(String fileName) {
        List<String> rawFruitRecords = new FruitRecordsDtoImpl().readDataFromFile(fileName);
        List<FruitRecord> fruitRecords = new ArrayList<>();
        Validator validator = new ValidatorImpl();
        rawFruitRecords.remove(TITLE_INDEX);
        for (String record: rawFruitRecords) {
            FruitRecord fruitRecord = new FruitRecord();
            String[] splitRecord = record.split(CSV_SEPARATOR);
            if (validator.validate(splitRecord)) {
                fruitRecord.setOperationType(splitRecord[OPERATION_TYPE_INDEX]);
                fruitRecord.setFruit(splitRecord[FRUIT_INDEX]);
                fruitRecord.setAmount(Integer.parseInt(splitRecord[AMOUNT_INDEX]));
                fruitRecords.add(fruitRecord);
            }
        }
        return fruitRecords;
    }
}
