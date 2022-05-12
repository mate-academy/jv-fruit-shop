package core.basesyntax.strategy.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer doOperation(Integer amount) {
        return -amount;
    }
}
