package core.basesyntax.service.validator.impl;

import core.basesyntax.service.validator.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    public static final String OPERATION_TYPE_ABBR = "bspr";
    public static final String DEFAULT_FRUIT_NAME_PATTERN = "[a-z]{3,15}";
    public static final String DEFAULT_QUANTITY_PATTERN = "[0-9]{1,15}";
    private static final int DEFAULT_OPERATION_TYPE_INDEX = 0;
    private static final int DEFAULT_FRUIT_NAME_INDEX = 1;
    private static final int DEFAULT_QUANTITY_INDEX = 2;
    private static final int REQUIRED_ARRAY_LENGTH = 3;

    @Override
    public boolean isValid(List<String> dataFromFile) {
        String[] currentLineArray;
        for (String currentLine : dataFromFile) {
            if (currentLine.equals("type,fruit,quantity")) {
                continue;
            }
            currentLineArray = currentLine.split(",");
            if (currentLineArray.length != REQUIRED_ARRAY_LENGTH) {
                throw new RuntimeException("Incorrect input data");
            }
            if (!OPERATION_TYPE_ABBR.contains(currentLineArray[DEFAULT_OPERATION_TYPE_INDEX])) {
                throw new RuntimeException("Unknown operation type");
            }
            if (!currentLineArray[DEFAULT_FRUIT_NAME_INDEX].matches(DEFAULT_FRUIT_NAME_PATTERN)) {
                throw new RuntimeException("Incorrect fruit name");
            }
            if (!currentLineArray[DEFAULT_QUANTITY_INDEX].matches(DEFAULT_QUANTITY_PATTERN)
                    || Integer.parseInt(currentLineArray[DEFAULT_QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("Incorrect fruit quantity");
            }
        }
        return true;
    }
}
