package core.basesyntax.service.operations;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int getOperationalQuantity(int quantity) {
        return quantity;
    }
}
