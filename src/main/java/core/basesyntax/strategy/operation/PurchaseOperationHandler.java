package core.basesyntax.strategy.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer getAmountToAdd(Integer amount) {
        return -amount;
    }
}
