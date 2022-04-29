package core.basesyntax.exception;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileValidation implements Validator {
    private static final int REQUIRED_LENGTH = 3;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;

    @Override
    public boolean checkFile(List<String> readFile) {
        for (String line : readFile) {
            String[] arrayFromLine = line.split(",");
            if (arrayFromLine.length != REQUIRED_LENGTH) {
                throw new RuntimeException("Length of the line "
                        + Arrays.toString(arrayFromLine) + " is invalid");
            }
            if (Objects.equals(arrayFromLine[FRUIT_NAME_INDEX], "")) {
                throw new RuntimeException("Fruits name is invalid "
                        + Arrays.toString(arrayFromLine));
            }
            if (Objects.equals(arrayFromLine[OPERATION_TYPE_INDEX], "")) {
                throw new RuntimeException("Operation type is invalid "
                        + Arrays.toString(arrayFromLine));
            }
            if (Integer.parseInt(arrayFromLine[QUANTITY_INDEX]) < 0) {
                throw new RuntimeException("File contains invalid value "
                        + arrayFromLine[QUANTITY_INDEX]);
            }
        }
        return true;
    }
}
