package core.basesyntax.validation;

public class OperationValidatorImpl implements OperationValidator {
    private static final int CORRECT_LENGTH_OF_SPLITTED_ROW = 3;
    private static final int INDEX_FRUIT_AMOUNT = 2;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_FRUIT_TYPE = 1;

    @Override
    public boolean isOperationValid(String[] data) {
        if (data.length != CORRECT_LENGTH_OF_SPLITTED_ROW
                || !data[INDEX_FRUIT_AMOUNT].matches("\\d+")
                || Integer.parseInt(data[INDEX_FRUIT_AMOUNT]) < 0
                || !data[INDEX_FRUIT_TYPE].matches("[A-Za-z]+")
                || !(data[INDEX_OPERATION_TYPE]).matches("[sprb]")) {
            throw new RuntimeException("Data in file is not valid");
        }
        return true;
    }
}
