package core.basesyntax.services.data;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class ParserCsv implements DataParser<Operation, String> {
    private static final int ITEM_INDEX_INDEX = 0;
    private static final int ITEM_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String DATA_SPLITTER = ",";

    @Override
    public List<Operation> formatData(List<String> data) {
        DataValidator dataValidator = new DataValidatorImpl();
        List<Operation> operations = new ArrayList<>();
        for (String rawData : data) {
            String[] rawDataArray = rawData.split(DATA_SPLITTER);
            dataValidator.validate(rawDataArray);
            operations.add(new Operation(Operation.Type.get(rawDataArray[ITEM_INDEX_INDEX]),
                    rawDataArray[ITEM_INDEX],
                    Integer.parseInt(rawDataArray[AMOUNT_INDEX])));
        }
        return operations;
    }
}
