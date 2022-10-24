package core.basesyntax.operation;

public class OperationHandlerBalanceImpl implements OperationHandler {
    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}
