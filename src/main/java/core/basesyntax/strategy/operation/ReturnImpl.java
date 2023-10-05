package core.basesyntax.strategy.operation;

class ReturnImpl implements OperationHandler {
    @Override
    public int execute(final int first, final int second) {
        return first + second;
    }
}
