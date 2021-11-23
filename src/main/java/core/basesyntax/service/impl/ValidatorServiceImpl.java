package core.basesyntax.service.impl;

import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.ValidatorServiceException;

public class ValidatorServiceImpl implements ValidatorService<String> {
    private static final int EXPECTED_ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int QUANTITY_OF_FRUITS_INDEX = 2;

    @Override
    public boolean validate(String line) {
        if (line.isEmpty()) {
            throw new ValidatorServiceException("Line is empty");
        }
        String[] information = line.split(",");
        if (information.length == EXPECTED_ARRAY_LENGTH
                && information[OPERATION_INDEX].matches("[b|s|p|r]")
                && Integer.parseInt(information[QUANTITY_OF_FRUITS_INDEX]) >= 0) {
            return true;
        }
        throw new ValidatorServiceException("Incorrect information: " + line);
    }
}
