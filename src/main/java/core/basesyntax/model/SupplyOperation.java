package core.basesyntax.model;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer makeOperation(Integer quantity) {
        return quantity;
    }
}
