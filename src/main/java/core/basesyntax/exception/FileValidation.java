package core.basesyntax.exception;

public class FileValidation implements Validator {
    private static final int TOTAL_LENGTH = 3;
    private static final int QUANTITY = 2;

    @Override
    public boolean checkFile(String[] fields, String line) {
        if (fields.length != TOTAL_LENGTH) {
            throw new RuntimeException("Length of the line " + fields + " is invalid");
        }
        if (Integer.parseInt(fields[QUANTITY]) < 0) {
            throw new RuntimeException("File contains invalid value " + fields[QUANTITY]);
        }
        return true;
    }
}
