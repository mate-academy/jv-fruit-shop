package core.basesyntax.service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public Integer updateBalance(Integer balance, Integer value) {
        if (value > balance) {
            throw new RuntimeException("Invalid data");
        }
        return balance - value;
    }
}
