package core.basesyntax.validate;

public interface Validator {
    boolean validationData(String operation, String fruitName, String quantity);

    boolean validationOfOperation(String operation);

    boolean validationOfFruitName(String fruitName);

    boolean validationOfQuantity(String quantity);
}
