package core.basesyntax.validate;

public interface ValidationData {
    boolean validationData(String operation, String fruitName, String quantity);

    boolean validationByOperation(String operation);

    boolean validationByFruitName(String fruitName);

    boolean validationByQuantity(String quantity);
}
