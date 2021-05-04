package core.basesyntax.dto;

import core.basesyntax.exceptions.InvalidOperationException;

public class OperationValidator {
    public boolean validateOperation(Operation operation)
            throws InvalidOperationException {
        if (operation == null) {
            throw new InvalidOperationException("The operation object is null!");
        }
        if (operation.getOperationType() == null) {
            throw new InvalidOperationException("The operation type is null!");
        }
        if (operation.getFruit() == null) {
            throw new InvalidOperationException("The operation fruit is null!");
        }
        if (operation.getOperationType().equals(Operation.OperationType.UNKNOWN)) {
            throw new InvalidOperationException("Operation type is unknown!");
        }
        if (operation.getQuantity() < 0 || operation.getQuantity() == 0) {
            throw new InvalidOperationException("Quantity is less or equals zero! Quantity have "
                    + "to be greater than zero!");
        }
        return true;
    }
}
