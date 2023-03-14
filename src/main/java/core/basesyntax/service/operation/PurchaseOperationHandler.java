package core.basesyntax.service.operation;

public class PurchaseOperationHandler implements OperationHandler{

    @Override
    public int doCalculation(int amount) {
        return -amount;
    }
}
