package core.basesyntax.service.handler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer handle(int quantity) {
        return Math.negateExact(quantity);
    }
}
