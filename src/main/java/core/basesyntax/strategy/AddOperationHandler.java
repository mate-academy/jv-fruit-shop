package core.basesyntax.strategy;

public class AddOperationHandler implements core.basesyntax.strategy.OperationHandler {
    @Override
    public int apply(int current, int transaction) {
        return current + transaction;
    }
}
