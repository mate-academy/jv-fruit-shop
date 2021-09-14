package core.basesyntax.service.files;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.validation.DataValidator;
import core.basesyntax.service.validation.DataValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class InputRowParserImpl implements InputRowParser {
    private static final String DATA_DIVIDER = ",";

    @Override
    public List<FruitRecord> parse(List<String> fileData) {
        List<FruitRecord> fruitRecords = new ArrayList<>();
        for (String row : fileData) {
            String[] inputRowData = row.split(DATA_DIVIDER);
            DataValidator isInputRowValid = new DataValidatorImpl();
            isInputRowValid.validate(inputRowData);
            String fruitName = inputRowData[1];
            FruitRecord.Type operationType = FruitRecord.Type.getType(inputRowData[0]);
            int fruitsAmount = Integer.parseInt(inputRowData[2]);
            fruitRecords.add(new FruitRecord(fruitsAmount, fruitName, operationType));
        }
        return fruitRecords;
    }
}
