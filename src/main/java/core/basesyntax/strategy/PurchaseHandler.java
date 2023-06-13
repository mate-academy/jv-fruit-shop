package core.basesyntax.strategy;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int execudeOperation(int currentQuantity, int quantityFromTransaction) {
        return currentQuantity - quantityFromTransaction;
    }
}
