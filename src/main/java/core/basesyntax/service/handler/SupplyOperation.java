package core.basesyntax.service.handler;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer handle(int quantity) {
        return quantity;
    }
}
