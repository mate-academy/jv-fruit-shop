package core.basesyntax.service.strategy;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public int apply(int balanceValue, int valueToChangeBalance) {
        return valueToChangeBalance;
    }
}
