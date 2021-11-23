package core.basesyntax.strategy.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer getShopOperation(Integer amount) {
        return amount;
    }
}
