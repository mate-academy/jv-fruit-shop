package core.basesyntax.strategy;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public int getResultOfOperation(int quantity) {
        return quantity;
    }
}
