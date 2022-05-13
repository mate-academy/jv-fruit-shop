package core.basesyntax.strategy.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer handle(Integer amount) {
        return amount;
    }
}
