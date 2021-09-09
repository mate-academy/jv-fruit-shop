package core.basesyntax.service.data;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class CsvOperationParser implements DataParser<Operation, String> {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String DATA_SPLITTER = ",";

    @Override
    public List<Operation> formatData(List<String> data) {
        DataValidator dataValidator = new DataValidatorImpl();
        List<Operation> operations = new ArrayList<>();
        for (String datum : data) {
            String[] datumArray = datum.split(DATA_SPLITTER);
            dataValidator.validate(datumArray);
            operations.add(new Operation(Operation.Type.get(datumArray[TYPE_INDEX]),
                    datumArray[FRUIT_INDEX],
                    Integer.parseInt(datumArray[AMOUNT_INDEX])));
        }
        return operations;
    }
}
