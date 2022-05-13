package core.basesyntax.strategy.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer handle(Integer amount) {
        return -amount;
    }
}
