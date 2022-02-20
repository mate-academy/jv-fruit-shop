package core.basesyntax.service.handler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        return inputQuantity + currentQuantity;
    }
}
