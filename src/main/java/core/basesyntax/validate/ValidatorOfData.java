package core.basesyntax.validate;

public class ValidatorOfData implements Validator {
    private static final String EXCEPTION_MESSAGE = "Invalid data";

    @Override
    public boolean validationData(String operation, String fruitName, String quantity) {
        validationOfOperation(operation);
        validationOfFruitName(fruitName);
        validationOfQuantity(quantity);
        return true;
    }

    @Override
    public boolean validationOfOperation(String operation) {
        String validOperationRegex = "[^bspr]";
        if (operation.replaceAll(validOperationRegex, "").length() < operation.trim().length()) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean validationOfFruitName(String fruitName) {
        String validNameRegex = "[^A-z]";
        if (fruitName.length() > fruitName.replaceAll(validNameRegex, "").length()) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return true;
    }

    @Override
    public boolean validationOfQuantity(String quantity) {
        String validQuantityRegex = "[^0-9]";
        if (quantity.length() > quantity.replaceAll(validQuantityRegex, "").length()) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return true;
    }
}
