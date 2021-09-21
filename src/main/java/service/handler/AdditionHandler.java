package service.handler;

public class AdditionHandler implements OperationHandler {
    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue + value;
    }
}
