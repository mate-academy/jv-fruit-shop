package core.basesyntax.strategy.operation;

class SupplyImpl implements OperationHandler {
    @Override
    public int execute(final int first, final int second) {
        return first + second;
    }
}
