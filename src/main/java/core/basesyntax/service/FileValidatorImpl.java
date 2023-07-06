package core.basesyntax.service;

import java.util.Arrays;

public class FileValidatorImpl implements FileValidator {
    private static final int LAST_CELL_NUMBER = 2;

    @Override
    public void validate(String[] dataLine) {
        if (dataLine.length != 3) {
            throw new RuntimeException("Incorrect quantity input data in this line: "
                    + Arrays.toString(dataLine));
        } else if (Integer.parseInt(dataLine[LAST_CELL_NUMBER]) < 0) {
            throw new RuntimeException("Impossible input for quantity data: "
                    + dataLine[LAST_CELL_NUMBER]);
        }
    }
}
