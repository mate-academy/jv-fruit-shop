package core.basesyntax.service.operation;

public class SupplierHandler implements OperationHandler {

    @Override
    public int getOperationAction(int quantity) {
        return quantity;
    }
}
