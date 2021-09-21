package core.basesyntax.fruitshop.validator;

public class ValidatorImpl implements Validator {
    private static final int OPERATIONS_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;

    @Override
    public boolean validateTransaction(String[] operation) {
        if (operation.length != 3 || operation[OPERATIONS_POSITION].isEmpty()
                || operation[FRUIT_NAME_POSITION].isEmpty()
                || operation[AMOUNT_POSITION].isEmpty()) {
            throw new RuntimeException("Incorrect data in file. String don't have needed data!");
        }

        if (isNumeric(operation[AMOUNT_POSITION]) && !(Integer.parseInt(operation[AMOUNT_POSITION]) > 0)) {
            throw new RuntimeException("Incorrect quantity. Quantity can't be less by zero");
        }

        if (!containsSpecificChars(operation[OPERATIONS_POSITION])) {
            throw new RuntimeException("Incorrect data in file. This operation don't exist");
        }
        return  true;
    }

    private boolean isNumeric(String str) {
        if (str.length() == 0) {
            return false;
        }
        return str.chars().allMatch(Character::isDigit);
    }

    private boolean containsSpecificChars(String str) {
        if (str.length() == 1 && str.indexOf('b') != -1
                || str.indexOf('s') != -1 || str.indexOf('p') != -1
                || str.indexOf('r') != -1) {
            return true;
        }
        return false;
    }
}
