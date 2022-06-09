package core.basesyntax.strategy.handler;

public class SupplyHandler implements OperationHandler {
    @Override
    public Integer getOperationHandler(int quantity, int value) {
        return quantity + value;
    }
}
