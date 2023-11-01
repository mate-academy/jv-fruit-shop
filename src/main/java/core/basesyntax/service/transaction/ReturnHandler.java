package core.basesyntax.service.transaction;

public class ReturnHandler implements OperationHandler {
    @Override
    public int countQuantity(int currentAmount, int operationAmount) {
        int sum = currentAmount + operationAmount;
        return sum;
    }
}
