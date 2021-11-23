package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public boolean validate(List<String> data) {
        for (String line : data) {
            String[] splittedLine = line.split(",");
            if (splittedLine.length != 3
                    || splittedLine[INDEX_OF_OPERATION].length() != 1
                    || splittedLine[INDEX_OF_FRUIT].length() < 1
                    || Integer.parseInt(splittedLine[INDEX_OF_QUANTITY]) < 0) {
                throw new RuntimeException("Format of file is incorrect");
            }
        }
        return true;
    }
}
