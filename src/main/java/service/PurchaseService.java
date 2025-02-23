package service;

public class PurchaseService implements OperationService {
    @Override
    public int operate(int operationAmount, int balanceAmount) {
        return balanceAmount - operationAmount;
    }
}
