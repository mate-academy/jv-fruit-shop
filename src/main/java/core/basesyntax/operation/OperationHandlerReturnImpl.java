package core.basesyntax.operation;

public class OperationHandlerReturnImpl implements OperationHandler {
    @Override
    public int operate(int first, int second) {
        return first + second;
    }
}
