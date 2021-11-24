package core.basesyntax.service.impl;

import core.basesyntax.exception.ValidatorServiceException;
import core.basesyntax.service.ValidatorService;

public class ValidatorServiceImpl implements ValidatorService {
    private static final int ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public boolean validate(String line) {
        if (line.isEmpty()) {
            throw new ValidatorServiceException("File is empty!");
        }
        String[] dataFromLine = line.split(",");
        if (dataFromLine.length == ARRAY_LENGTH
                && dataFromLine[OPERATION_INDEX].matches("[bspr]")
                && dataFromLine[FRUIT_INDEX].matches("[a-z]+")
                && dataFromLine[QUANTITY_INDEX].matches("[0-9]+")) {
            return true;
        }
        throw new ValidatorServiceException("Incorrect information: " + line);
    }
}
