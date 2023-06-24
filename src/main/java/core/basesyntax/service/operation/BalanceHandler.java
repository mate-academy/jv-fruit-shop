package core.basesyntax.service.operation;

public class BalanceHandler implements OperationHandler {
    @Override
    public int getOperationAction(int quantity) {
        return quantity;
    }
}
