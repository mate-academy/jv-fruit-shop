package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.List;

public class ValidatorImpl implements Validator {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int REQUIRED_LENGTH = 3;

    @Override
    public boolean validate(List<String> data) {
        for (String line : data) {
            String[] splittedLine = line.split(",");
            if (line.equals("type,fruit,quantity")) {
                continue;
            }
            if (splittedLine.length != REQUIRED_LENGTH
                    || splittedLine[INDEX_OF_OPERATION].length() != 1
                    || !splittedLine[INDEX_OF_OPERATION].contains("b")
                    && !splittedLine[INDEX_OF_OPERATION].contains("p")
                    && !splittedLine[INDEX_OF_OPERATION].contains("r")
                    && !splittedLine[INDEX_OF_OPERATION].contains("s")
                    || splittedLine[INDEX_OF_FRUIT].length() < 1
                    || !splittedLine[INDEX_OF_FRUIT].matches("[a-zA-Z]*")
                    || Integer.parseInt(splittedLine[INDEX_OF_QUANTITY]) < 0) {
                throw new RuntimeException("Format of file is incorrect");
            }
        }
        return true;
    }
}
