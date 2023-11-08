package core.basesyntax.dao.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer useOperation(Integer quantity) {
        return quantity * -1;
    }
}
