package core.basesyntax.model;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer makeOperation(Integer quantity) {
        return quantity * -1;
    }
}
