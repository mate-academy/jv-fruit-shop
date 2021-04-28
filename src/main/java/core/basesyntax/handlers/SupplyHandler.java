package core.basesyntax.handlers;

public class SupplyHandler implements Activitie {
    @Override
    public int calculateCount(int currentCount, int newCount) {
        return currentCount + newCount;
    }
}
