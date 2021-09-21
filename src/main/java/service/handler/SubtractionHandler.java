package service.handler;

public class SubtractionHandler implements OperationHandler {
    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue - value;
    }
}
