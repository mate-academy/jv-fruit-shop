package core.basesyntax.service.strategy;

public class PurchaseOperationHandler implements OperationHandler {

    public PurchaseOperationHandler() {
    }

    @Override
    public Integer applyOperation(Integer amount) {
        return -amount;
    }
}
