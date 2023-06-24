package core.basesyntax.service.handler;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer handle(int quantity) {
        return quantity;
    }
}
