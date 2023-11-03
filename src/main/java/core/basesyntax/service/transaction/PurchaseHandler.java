package core.basesyntax.service.transaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int countQuantity(int currentAmount, int operationAmount) {
        return currentAmount - operationAmount;
    }
}
