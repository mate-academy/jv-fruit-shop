package core.basesyntax.validate;

public class ValidationSubtractOperationValue implements ValidationSubtractOperation {
    private static final String EXCEPTION_MESSAGE = "Can't decrease this value";

    @Override
    public boolean validateDeleteOperation(Integer currentQuantity, Integer deleteQuantity) {
        if (currentQuantity < deleteQuantity) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return true;
    }
}
