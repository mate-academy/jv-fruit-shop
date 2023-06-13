package core.basesyntax.strategy;

public class BalanceHandler implements OperationHandler {
    @Override
    public int execudeOperation(int currentQuantity, int quantityFromTransaction) {
        return quantityFromTransaction;
    }
}
