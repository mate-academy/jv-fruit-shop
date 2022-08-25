package core.basesyntax.service.strategy;

public class ActivityBalanceImpl implements ActivityStrategy {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
