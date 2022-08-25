package core.basesyntax.service.strategy;

public class ActivityReturnImpl implements ActivityStrategy {
    @Override
    public int prepareCount(int value) {
        return value;
    }
}
