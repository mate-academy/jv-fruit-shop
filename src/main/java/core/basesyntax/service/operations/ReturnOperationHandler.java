package core.basesyntax.service.operations;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getOperationalQuantity(int quantity) {
        return quantity * (-1);
    }
}
