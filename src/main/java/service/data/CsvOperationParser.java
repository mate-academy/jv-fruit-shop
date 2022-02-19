package service.data;

import java.util.ArrayList;
import java.util.List;
import model.Operation;

public class CsvOperationParser implements DataParser<Operation, String> {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Operation> formatData(List<String> data) {
        DataValidator dataValidator = new DataValidatorImpl();
        List<Operation> operations = new ArrayList<>();
        for (String datum : data) {
            String[] datumArray = datum.split(SEPARATOR);
            dataValidator.validate(datumArray);
            operations.add(new Operation(Operation.Type.get(datumArray[TYPE]),
                    datumArray[FRUIT],
                    Integer.parseInt(datumArray[QUANTITY])));
        }
        return operations;
    }
}
