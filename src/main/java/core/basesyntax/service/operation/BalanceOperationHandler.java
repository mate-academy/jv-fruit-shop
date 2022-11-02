package core.basesyntax.service.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int doOperation(int balance, int quantity) {
        return quantity;
    }
}
