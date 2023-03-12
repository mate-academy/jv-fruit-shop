package core.basesyntax.strategy;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int doOperation(int balance, int quantity) {
        return balance + quantity;
    }
}
