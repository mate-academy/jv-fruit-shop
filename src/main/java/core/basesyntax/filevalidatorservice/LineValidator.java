package core.basesyntax.filevalidatorservice;

public interface LineValidator {
    boolean correctOperation(String operation);

    boolean correctQuantity(String quantity);

    boolean lineValidator(String[] line);
}
