package core.basesyntax.service.strategy;

public class ActivitySupplyImpl implements ActivityStrategy {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
