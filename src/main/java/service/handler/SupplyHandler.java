package service.handler;

public class SupplyHandler implements OperationHandler {

    @Override
    public int calculateValue(int oldValue, int value) {
        return oldValue + value;
    }
}
