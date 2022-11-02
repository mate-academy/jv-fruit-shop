package core.basesyntax.strategy;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int doOperation(int balance, int quantity) {
        return quantity;
    }
}
