package core.basesyntax.model;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer handle(Integer quantity) {
        return quantity;
    }
}
