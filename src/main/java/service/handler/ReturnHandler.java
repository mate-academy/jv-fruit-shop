package service.handler;

public class ReturnHandler implements OperationHandler {

    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue + value;
    }
}
