package core.basesyntax.model;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer makeOperation(Integer quantity) {
        return quantity;
    }
}
