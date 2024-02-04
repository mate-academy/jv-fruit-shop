package core.basesyntax.service.strategy;

public class DefectiveStrategy implements OperationStrategy {
    @Override
    public int apply(int balanceValue, int valueToChangeBalance) {
        return balanceValue - valueToChangeBalance;
    }
}
