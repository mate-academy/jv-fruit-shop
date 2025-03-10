package core.basesyntax.model;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer handle(Integer quantity) {
        return quantity;
    }
}
