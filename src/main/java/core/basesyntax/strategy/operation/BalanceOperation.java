package core.basesyntax.strategy.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer doOperation(Integer amount) {
        return amount;
    }
}
