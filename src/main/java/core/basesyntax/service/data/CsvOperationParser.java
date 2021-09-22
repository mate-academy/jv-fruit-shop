package core.basesyntax.service.data;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class CsvOperationParser implements DataParserImpl<Operation, String> {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String DATA_SPLITTER = ",";
    public static final int FIRST_LINE_OF_CSV = 0;

    @Override
    public List<Operation> formatData(List<String> data) {
        DataValidator dataValidator = new DataValidatorImpl();
        List<Operation> operations = new ArrayList<>();
        data.remove(FIRST_LINE_OF_CSV);
        for (String proper : data) {
            String[] properArray = proper.split(DATA_SPLITTER);
            dataValidator.validate(properArray);
            operations.add(new Operation(Operation.Type.get(properArray[TYPE_INDEX]),
                    properArray[FRUIT_INDEX],
                    Integer.parseInt(properArray[AMOUNT_INDEX])));
        }
        return operations;
    }
}
