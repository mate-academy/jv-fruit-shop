package core.basesyntax.service.strategy;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public int apply(int balanceValue, int valueToChangeBalance) {
        return balanceValue + valueToChangeBalance;
    }
}
