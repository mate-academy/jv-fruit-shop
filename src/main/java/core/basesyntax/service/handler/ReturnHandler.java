package core.basesyntax.service.handler;

public class ReturnHandler implements OperationHandler {
    @Override
    public Integer getOperationHandler(int quantity, int value) {
        return quantity + value;
    }
}
