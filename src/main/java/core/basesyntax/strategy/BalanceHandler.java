package core.basesyntax.strategy;

public class BalanceHandler implements OperationHandler {

    @Override
    public int apply(int current, int transaction) {
        return transaction;
    }
}
