package core.basesyntax.model;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer handle(Integer quantity) {
        return -quantity;
    }
}
