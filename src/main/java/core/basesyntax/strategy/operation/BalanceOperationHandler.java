package core.basesyntax.strategy.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public Integer getAmountToAdd(Integer amount) {
        return amount;
    }
}
