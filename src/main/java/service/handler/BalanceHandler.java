package service.handler;

public class BalanceHandler implements OperationHandler {

    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue + value;
    }
}
