package core.basesyntax.service.strategy;

public class ActivityPurchaseImpl implements ActivityStrategy {
    @Override
    public int prepareCount(int value) {
        return value * (-1);
    }
}
