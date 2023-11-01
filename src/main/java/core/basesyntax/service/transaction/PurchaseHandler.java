package core.basesyntax.service.transaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int countQuantity(int currentAmount, int operationAmount) {
        int subtraction = currentAmount - operationAmount;
        return subtraction;
    }
}
