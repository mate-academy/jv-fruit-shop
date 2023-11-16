package core.basesyntax.dao.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer useOperation(Integer quantity) {
        return quantity;
    }
}
