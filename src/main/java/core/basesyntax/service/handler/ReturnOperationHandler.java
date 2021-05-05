package core.basesyntax.service.handler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int calculateQuantity(int currentQuantity, int inputQuantity) {
        return currentQuantity + inputQuantity;
    }
}
