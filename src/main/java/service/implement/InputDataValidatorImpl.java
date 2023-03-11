package service.implement;

import java.util.List;
import service.InputDataValidator;
import service.Operation;

public class InputDataValidatorImpl implements InputDataValidator {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public boolean validate(List<String> input) {
        if (input.isEmpty() || !input.get(0).equals("type,fruit,quantity")) {
            throw new RuntimeException("invalid data");
        }
        input.remove(0);
        int stringNumber = 2;
        for (String string: input) {
            String[] values = string.split(",");
            if (values.length != 3) {
                throw new RuntimeException("invalid data at line № " + stringNumber);
            }
            if (!Operation.contains(values[OPERATION_INDEX])) {
                throw new RuntimeException("invalid operation at line №" + stringNumber);
            }
            if (values[FRUIT_INDEX].length() <= 0 || !values[FRUIT_INDEX].matches("[a-zA-Z]+")) {
                throw new RuntimeException("invalid fruit name at line № " + stringNumber);
            }
            try {
                int quantity = Integer.parseInt(values[QUANTITY_INDEX]);
            } catch (RuntimeException e) {
                throw new RuntimeException("invalid quantity at line № " + stringNumber);
            }
            stringNumber++;
        }
        return true;
    }
}
