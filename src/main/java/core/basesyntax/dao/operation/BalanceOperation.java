package core.basesyntax.dao.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer useOperation(Integer quantity) {
        return quantity;
    }
}
