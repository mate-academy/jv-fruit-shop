package core.basesyntax.service.validation;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final String COMMA = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final String OPERATION_TYPE_EXAMPLE = "[bpsr]";
    private static final String FRUIT_NAME_EXAMPLE = "[A-Za-z]{3,12}";
    private static final int FRUIT_AMOUNT_INDEX = 2;
    private static final int FRUIT_AMOUNT_MINIMUM = 1;

    @Override
    public boolean isValid(List<String> readReport) {
        if (readReport.isEmpty()) {
            throw new RuntimeException(("Incorrect input data!"));
        }
        for (String data : readReport) {
            String[] line = data.split(COMMA);
            if (line.length != 3) {
                throw new RuntimeException("Incorrect input data!");
            }
            if (!line[OPERATION_TYPE_INDEX].matches(OPERATION_TYPE_EXAMPLE)) {
                throw new RuntimeException("Incorrect operation type");
            }
            if (!line[FRUIT_NAME_INDEX].matches(FRUIT_NAME_EXAMPLE)) {
                throw new RuntimeException("Incorrect fruit name");
            }
            if (Integer.parseInt(line[FRUIT_AMOUNT_INDEX]) < FRUIT_AMOUNT_MINIMUM) {
                throw new RuntimeException("Incorrect fruit amount");
            }
        }
        return true;
    }
}
